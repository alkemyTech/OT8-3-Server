package com.alkemy.wallet.service;
import com.alkemy.wallet.dto.AccountRequestDTO;
import com.alkemy.wallet.dto.AccountResponseDTO;
import com.alkemy.wallet.enums.CurrencyEnum;
import com.alkemy.wallet.model.Account;
import com.alkemy.wallet.model.User;
import com.alkemy.wallet.repository.AccountRepository;
import com.alkemy.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
}
