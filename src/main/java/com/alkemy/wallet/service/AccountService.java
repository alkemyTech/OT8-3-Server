package com.alkemy.wallet.service;
import com.alkemy.wallet.dto.*;
import com.alkemy.wallet.enums.CurrencyEnum;
import com.alkemy.wallet.model.Account;
import com.alkemy.wallet.model.User;
import com.alkemy.wallet.repository.AccountRepository;
import com.alkemy.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class AccountService {


    private AccountRepository accountRepository;
    private UserRepository userRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public List<Account> getAccountsByUserId(Long id){

        return accountRepository.getAccountsByUserId(id);
    }

    public AccountResponseDTO createAccount (AccountRequestDTO accountRequestDTO){
        Double transactionLimit = accountRequestDTO.getCurrency().toUpperCase().equals("ARS") ? 300000.0 : 1000.0;
        User user =  userRepository.findById(Long.decode(accountRequestDTO.getUserAuthenticated())).orElseThrow(()-> new IllegalStateException("User not found"));

        Account account = new Account(
                user,
                CurrencyEnum.valueOf(accountRequestDTO.getCurrency().toUpperCase()),
                transactionLimit
        );
        Account savedAccount = accountRepository.save(account);
        AccountResponseDTO response = new AccountResponseDTO();
        response.setCurrency(savedAccount.getCurrencyEnum().name());
        response.setBalance(savedAccount.getBalance());
        response.setUserId(user.getId().toString());
        response.setTransactionLimit(savedAccount.getTransactionLimit());
        return response;
    }

    public AccountUpdateResponseDTO updateAccount (AccountUpdateDTO accountUpdateDTO, String userAuthEmail, String accountId){
        User userAuth = userRepository.findByEmail(userAuthEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Account account = accountRepository.getAccountsByUserId(userAuth.getId())
                .stream()
                .filter(a -> a.getId().equals(Long.decode(accountId)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no se encontro algo"));

        if(account.getUser() != null && account.getId() != null) {
                account.setTransactionLimit(accountUpdateDTO.getTransactionLimit());
                Account accountNewLimit = accountRepository.save(account);
                AccountUpdateResponseDTO accountUpdateResponse = new AccountUpdateResponseDTO();
                accountUpdateResponse.setNewTransactionLimit(accountNewLimit.getTransactionLimit());
                return accountUpdateResponse;
            } else {throw new IllegalStateException("no anda nada");}
        }
    }

//setTransactionLimit(AccountUpdateResponseDTO)
