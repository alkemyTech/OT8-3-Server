package com.alkemy.wallet.controller;

import com.alkemy.wallet.dto.*;
import com.alkemy.wallet.model.Account;
import com.alkemy.wallet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Account>> getAccountsByUserId(@PathVariable Long id) {
        List<Account> account = accountService.getAccountsByUserId(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<AccountResponseDTO> createAccount (@RequestBody AccountRequestDTO accountRequestDTO){
        return new ResponseEntity<>(accountService.createAccount(accountRequestDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{accountId}")
    public ResponseEntity<AccountUpdateResponseDTO>updateAccount(@RequestBody AccountUpdateDTO accountUpdateDTO,@PathVariable String accountId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        this.accountService.updateAccount(accountUpdateDTO, authentication.getName(), accountId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

