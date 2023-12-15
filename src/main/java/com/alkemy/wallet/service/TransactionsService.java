package com.alkemy.wallet.service;

import com.alkemy.wallet.dto.PaymentDTO;
import com.alkemy.wallet.dto.PaymentResponseDTO;
import com.alkemy.wallet.dto.TransactionDTO;
import com.alkemy.wallet.enums.TypeEnum;
import com.alkemy.wallet.model.Account;
import com.alkemy.wallet.model.Transactions;
import com.alkemy.wallet.repository.AccountRepository;
import com.alkemy.wallet.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionsService {
    private AccountRepository accountRepository;
    private TransactionsRepository transactionsRepository;
    @Autowired
    public TransactionsService(AccountRepository accountRepository, TransactionsRepository transactionsRepository) {
        this.accountRepository = accountRepository;
        this.transactionsRepository = transactionsRepository;
    }

    public PaymentResponseDTO payment(PaymentDTO paymentDTO){
       Account accountIsValid = accountRepository.findById(paymentDTO.getAccountId()).orElseThrow(()->new IllegalStateException("Account not found"));
        Transactions transaction = new Transactions (paymentDTO.getAmount(), TypeEnum.PAYMENT, paymentDTO.getDescription(), new Date());
        transaction.setAccount(accountIsValid);
          if(accountIsValid.getBalance() >= paymentDTO.getAmount()){
           if(accountIsValid.getCurrency().name().equals(paymentDTO.getCurrency())){
               transactionsRepository.save(transaction);
               accountIsValid.setBalance(accountIsValid.getBalance() - paymentDTO.getAmount());
               accountRepository.save(accountIsValid);
           } // aca el else de account currency is valid
       }
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionDate(transaction.getTransactionDate());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setDescription(transaction.getDescription());
        transactionDTO.setType(transaction.getTypeEnum().name());

        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
        paymentResponseDTO.setAccountId(accountIsValid.getId().toString());
        paymentResponseDTO.setTransaction(transactionDTO);

       return paymentResponseDTO;
    }
}
