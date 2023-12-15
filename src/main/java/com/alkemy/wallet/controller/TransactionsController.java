package com.alkemy.wallet.controller;

import com.alkemy.wallet.dto.PaymentDTO;
import com.alkemy.wallet.dto.PaymentResponseDTO;
import com.alkemy.wallet.service.TransactionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionsController {

    private TransactionsService transactionsService;

    @Autowired
    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentResponseDTO> payment(@RequestBody @Valid PaymentDTO paymentDTO){
        return new ResponseEntity<>(transactionsService.payment(paymentDTO), HttpStatus.CREATED);
    }
}
