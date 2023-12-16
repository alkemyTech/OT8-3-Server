package com.alkemy.wallet.controller;

import com.alkemy.wallet.dto.DepositPaymentDTO;
import com.alkemy.wallet.dto.DepositPaymentResponseDTO;
import com.alkemy.wallet.dto.IncomeTransactionDTO;
import com.alkemy.wallet.dto.TransactionDTO;
import com.alkemy.wallet.service.TransactionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionsController {

    private TransactionsService transactionsService;

    @Autowired
    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping("/payment")
    public ResponseEntity<DepositPaymentResponseDTO> payment(@RequestBody @Valid DepositPaymentDTO depositPaymentDTO){
        return new ResponseEntity<>(transactionsService.payment(depositPaymentDTO), HttpStatus.CREATED);
    }
    @PostMapping("/deposit")
    public ResponseEntity<DepositPaymentResponseDTO> deposit(@RequestBody @Valid DepositPaymentDTO depositPaymentDTO){
        return new ResponseEntity<>(transactionsService.deposit(depositPaymentDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    public List<TransactionDTO> getTransactionsByUserId(@PathVariable Long userId) {
        return transactionsService.getTransactionsByUserId(userId);
    }
    @GetMapping("/{id}/")
    public TransactionDTO getTransactionById(@PathVariable Long id) {
        return transactionsService.getTransactionById(id);
    }
    @PostMapping("/sendArs")
    public ResponseEntity<?> sendArs(@RequestBody IncomeTransactionDTO incomeTransactionDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        this.transactionsService.sendArs(incomeTransactionDTO , authentication.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/sendUsd")
    public ResponseEntity<?> sendUsd(@RequestBody IncomeTransactionDTO incomeTransactionDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        this.transactionsService.sendUsd(incomeTransactionDTO , authentication.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
