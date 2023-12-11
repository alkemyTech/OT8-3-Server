package com.alkemy.wallet.controller;

import com.alkemy.wallet.DTO.TransactionsDto;
import com.alkemy.wallet.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

        @GetMapping("{id}")
        public ResponseEntity<List<TransactionsDto>> getTransactionsByUserId(@PathVariable Long id) {
            List<TransactionsDto> transactionsDTO = transactionsService.getTransactionsByUserId(id);
            return new ResponseEntity<>(transactionsDTO, HttpStatus.OK);
        }
}
