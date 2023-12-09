package com.alkemy.wallet.service;

import com.alkemy.wallet.model.Transactions;
import com.alkemy.wallet.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    public List<Transactions> getTransactionsByUserId(Long id){

        return transactionsRepository.getTransactionsByUserId(id);
    }
}
