package com.alkemy.wallet.service;
import com.alkemy.wallet.model.Account;
import com.alkemy.wallet.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccountsByUserId(Long id){

        return accountRepository.getAccountsByUserId(id);
    }



}
