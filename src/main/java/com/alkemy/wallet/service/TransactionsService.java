package com.alkemy.wallet.service;

import com.alkemy.wallet.dto.*;
import com.alkemy.wallet.enums.TypeEnum;
import com.alkemy.wallet.model.Account;
import com.alkemy.wallet.model.Transactions;
import com.alkemy.wallet.repository.AccountRepository;
import com.alkemy.wallet.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransactionsService {
    private AccountRepository accountRepository;
    private TransactionsRepository transactionsRepository;
    @Autowired
    public TransactionsService(AccountRepository accountRepository, TransactionsRepository transactionsRepository) {
        this.accountRepository = accountRepository;
        this.transactionsRepository = transactionsRepository;
    }

    public DepositPaymentResponseDTO payment(DepositPaymentDTO depositPaymentDTO){
       Account accountIsValid = accountRepository.findById(depositPaymentDTO.getAccountId()).orElseThrow(()->new IllegalStateException("Account not found"));
        Transactions transaction = new Transactions (depositPaymentDTO.getAmount(), TypeEnum.PAYMENT, depositPaymentDTO.getDescription(), new Date());
        transaction.setAccount(accountIsValid);
          if(accountIsValid.getBalance() >= depositPaymentDTO.getAmount()){
           if(accountIsValid.getCurrency().name().equals(depositPaymentDTO.getCurrency())){
               transactionsRepository.save(transaction);
               accountIsValid.setBalance(accountIsValid.getBalance() - depositPaymentDTO.getAmount());
               accountRepository.save(accountIsValid);
           } throw new IllegalArgumentException("Invalid currency");
       }
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionDate(transaction.getTransactionDate());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setDescription(transaction.getDescription());
        transactionDTO.setType(transaction.getTypeEnum().name());

        DepositPaymentResponseDTO depositPaymentResponseDTO = new DepositPaymentResponseDTO();
        depositPaymentResponseDTO.setAccountId(accountIsValid.getId().toString());
        depositPaymentResponseDTO.setTransaction(transactionDTO);

       return depositPaymentResponseDTO;
    }
    public DepositPaymentResponseDTO deposit(DepositPaymentDTO depositPaymentDTO){
        Account accountIsValid = accountRepository.findById(depositPaymentDTO.getAccountId()).orElseThrow(()->new IllegalStateException("Account not found"));
        Transactions transaction = new Transactions (depositPaymentDTO.getAmount(), TypeEnum.DEPOSIT, depositPaymentDTO.getDescription(), new Date());
        transaction.setAccount(accountIsValid);
            if(accountIsValid.getCurrency().name().equals(depositPaymentDTO.getCurrency())){
                transactionsRepository.save(transaction);
                accountIsValid.setBalance(accountIsValid.getBalance() + depositPaymentDTO.getAmount());
                accountRepository.save(accountIsValid);
            }
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionDate(transaction.getTransactionDate());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setDescription(transaction.getDescription());
        transactionDTO.setType(transaction.getTypeEnum().name());

        DepositPaymentResponseDTO depositPaymentResponseDTO = new DepositPaymentResponseDTO();
        depositPaymentResponseDTO.setAccountId(accountIsValid.getId().toString());
        depositPaymentResponseDTO.setTransaction(transactionDTO);

        return depositPaymentResponseDTO;
    }
    public List<TransactionDTO> getTransactionsByUserId(Long userId) {
        List<Account> userAccounts = accountRepository.getAccountsByUserId(userId);

        if (userAccounts.isEmpty()) {
            throw new IllegalStateException("Account not found");
        }

        Account userAccount = userAccounts.get(0);

        List<Transactions> userTransactions = transactionsRepository.findByAccountId(userAccount.getId());

        return userTransactions.stream()
                .map(this::convertToTransactionDTO)
                .collect(Collectors.toList());
    }

    private TransactionDTO convertToTransactionDTO(Transactions transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionDate(transaction.getTransactionDate());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setDescription(transaction.getDescription());
        transactionDTO.setType(transaction.getTypeEnum().name());
        return transactionDTO;
    }
}
