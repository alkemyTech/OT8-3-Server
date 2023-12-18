package com.alkemy.wallet.service;

import com.alkemy.wallet.dto.*;
import com.alkemy.wallet.enums.CurrencyEnum;
import com.alkemy.wallet.enums.TypeEnum;
import com.alkemy.wallet.model.Account;
import com.alkemy.wallet.model.Transactions;
import com.alkemy.wallet.model.User;
import com.alkemy.wallet.repository.AccountRepository;
import com.alkemy.wallet.repository.TransactionsRepository;
import com.alkemy.wallet.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TransactionsService {
    private final Logger logger = LogManager.getLogger(TransactionsService.class);
    private AccountRepository accountRepository;
    private TransactionsRepository transactionsRepository;
    private UserRepository userRepository;

    @Autowired
    public TransactionsService(AccountRepository accountRepository, TransactionsRepository transactionsRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.transactionsRepository = transactionsRepository;
        this.userRepository = userRepository;
    }

    public DepositPaymentResponseDTO payment(DepositPaymentDTO depositPaymentDTO) {
        Account accountIsValid = accountRepository.findById(depositPaymentDTO.getAccountId()).orElseThrow(() -> new IllegalStateException("Account not found"));
        Transactions transaction = new Transactions(depositPaymentDTO.getAmount(), TypeEnum.PAYMENT, depositPaymentDTO.getDescription(), new Date());
        transaction.setAccount(accountIsValid);
        if (accountIsValid.getBalance() >= depositPaymentDTO.getAmount()) {
            if (accountIsValid.getCurrencyEnum().name().equals(depositPaymentDTO.getCurrency())) {
                transactionsRepository.save(transaction);
                accountIsValid.setBalance(accountIsValid.getBalance() - depositPaymentDTO.getAmount());
                accountRepository.save(accountIsValid);
            } else {
                throw new IllegalArgumentException("Invalid currency");
            }
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

    public DepositPaymentResponseDTO deposit(DepositPaymentDTO depositPaymentDTO) {
        Account accountIsValid = accountRepository.findById(depositPaymentDTO.getAccountId()).orElseThrow(() -> new IllegalStateException("Account not found"));
        Transactions transaction = new Transactions(depositPaymentDTO.getAmount(), TypeEnum.DEPOSIT, depositPaymentDTO.getDescription(), new Date());
        transaction.setAccount(accountIsValid);
        if (accountIsValid.getCurrencyEnum().name().equals(depositPaymentDTO.getCurrency())) {
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

    public List<TransactionDTO> getTransactionsByUserId( String userAuthEmail) {
        User userAuth = userRepository.findByEmail(userAuthEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        List<Account> userAccounts = accountRepository.getAccountsByUserId(userAuth.getId());

        if (userAccounts.isEmpty()) {
            throw new IllegalStateException("Account not found");
        }

        Account userAccount = userAccounts.get(0);

        List<Transactions> userTransactions = transactionsRepository.findByAccountId(userAccount.getId());

        return userTransactions.stream()
                .map(this::convertToTransactionDTO)
                .collect(Collectors.toList());
    }

    public TransactionDTO getTransactionById(Long id) {
        Optional<Transactions> transactionOptional = transactionsRepository.findById(id);
        Transactions transaction = transactionOptional.orElseThrow(() -> new IllegalStateException("Transaction not found"));

        return convertToTransactionDTO(transaction);
    }

    private TransactionDTO convertToTransactionDTO(Transactions transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionDate(transaction.getTransactionDate());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setDescription(transaction.getDescription());
        transactionDTO.setType(transaction.getTypeEnum().name());
        return transactionDTO;
    }

    public void sendArs(IncomeTransactionDTO incomeTransactionDTO, String userNameAuth) {
        User userSender = userRepository.findByEmail(userNameAuth)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Account accountUserSender = accountRepository.getAccountsByUserId(userSender.getId())
                .stream()
                .filter(a -> a.getCurrencyEnum().equals(CurrencyEnum.ARS))
                .toList()
                .get(0);
        Account accountUserReceiver = accountRepository.findById(Long.decode(incomeTransactionDTO.getAccountId()))
                .stream()
                .filter(a -> a.getCurrencyEnum().equals(CurrencyEnum.ARS))
                .toList()
                .get(0);
        if (accountUserSender != null && accountUserReceiver != null && !(accountUserSender.getId().equals(accountUserReceiver.getId()))
                && ! (accountUserSender.getTransactionLimit() <= incomeTransactionDTO.getAmount() )) {
            Transactions sendTransaction = new Transactions(incomeTransactionDTO.getAmount(), TypeEnum.PAYMENT, incomeTransactionDTO.getDescription(), new Date());
            sendTransaction.setAccount(accountUserSender);
            if (accountUserSender.getBalance() >= incomeTransactionDTO.getAmount()) {
                transactionsRepository.save(sendTransaction);
                accountUserSender.setBalance(accountUserSender.getBalance() - incomeTransactionDTO.getAmount());
                accountRepository.save(accountUserSender);

                Transactions receiveTransaction = new Transactions(incomeTransactionDTO.getAmount(), TypeEnum.INCOME, incomeTransactionDTO.getDescription(), new Date());
                receiveTransaction.setAccount(accountUserReceiver);
                transactionsRepository.save(receiveTransaction);
                accountUserReceiver.setBalance(accountUserReceiver.getBalance() + incomeTransactionDTO.getAmount());
                accountRepository.save(accountUserReceiver);
            } else {throw new IllegalStateException("el balance esta mal");}
        }else {throw new IllegalStateException("lo otro esta mal");}
    }
    public void sendUsd(IncomeTransactionDTO incomeTransactionDTO, String userNameAuth) {
        User userSender = userRepository.findByEmail(userNameAuth)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Account accountUserSender = accountRepository.getAccountsByUserId(userSender.getId())
                .stream()
                .filter(a -> a.getCurrencyEnum().equals(CurrencyEnum.USD))
                .toList()
                .get(0);
        Account accountUserReceiver = accountRepository.findById(Long.decode(incomeTransactionDTO.getAccountId()))
                .stream()
                .filter(a -> a.getCurrencyEnum().equals(CurrencyEnum.USD))
                .toList()
                .get(0);
        if (accountUserSender != null && accountUserReceiver != null && !(accountUserSender.getId().equals(accountUserReceiver.getId()))
                && ! (accountUserSender.getTransactionLimit() <= incomeTransactionDTO.getAmount() )) {
            Transactions sendTransaction = new Transactions(incomeTransactionDTO.getAmount(), TypeEnum.PAYMENT, incomeTransactionDTO.getDescription(), new Date());
            sendTransaction.setAccount(accountUserSender);
            if (accountUserSender.getBalance() >= incomeTransactionDTO.getAmount()) {
                transactionsRepository.save(sendTransaction);
                accountUserSender.setBalance(accountUserSender.getBalance() - incomeTransactionDTO.getAmount());
                accountRepository.save(accountUserSender);

                Transactions receiveTransaction = new Transactions(incomeTransactionDTO.getAmount(), TypeEnum.INCOME, incomeTransactionDTO.getDescription(), new Date());
                receiveTransaction.setAccount(accountUserReceiver);
                transactionsRepository.save(receiveTransaction);
                accountUserReceiver.setBalance(accountUserReceiver.getBalance() + incomeTransactionDTO.getAmount());
                accountRepository.save(accountUserReceiver);
            } else {throw new IllegalStateException("el balance esta mal");}
        }else {throw new IllegalStateException("lo otro esta mal");}
    }
}
