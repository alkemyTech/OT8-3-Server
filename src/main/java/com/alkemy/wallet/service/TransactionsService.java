package com.alkemy.wallet.service;

import com.alkemy.wallet.DTO.TransactionsDto;
import com.alkemy.wallet.model.Account;
import com.alkemy.wallet.model.Transactions;
import com.alkemy.wallet.model.User;
import com.alkemy.wallet.repository.TransactionsRepository;
import com.alkemy.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;
    private UserRepository userRepository;

    public List<TransactionsDto> getTransactionsByUserId(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Account> accounts = user.getAccounts();
            List<TransactionsDto> transactionsDTO = transactionsRepository.getTransactionsByUserId(user.getId());
            for (Account account : accounts) {
                List<Transactions> transactions = account.getTransactions();
                for (Transactions transaction : transactions) {
                    TransactionsDto transactionDTO = new TransactionsDto(
                            account.getId(),
                            transaction.getId(),
                            transaction.getAmount(),
                            transaction.getTypeEnum().name(),
                            transaction.getDescription(),
                            transaction.getTransactionDate()
                            );
                    transactionsDTO.add(transactionDTO);
                }
            }
            return transactionsDTO;
        }
        return null;
    }
}
