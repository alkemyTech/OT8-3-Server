package com.alkemy.wallet.controller;

import com.alkemy.wallet.dto.LoanRequestDTO;
import com.alkemy.wallet.dto.LoanResponseDTO;
import com.alkemy.wallet.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/loan", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoanController {
    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    private LoanService loanService;

    @PostMapping("/simulate")
    public ResponseEntity<LoanResponseDTO> simulateLoan(@RequestBody LoanRequestDTO loanRequest){
        return new ResponseEntity<>(loanService.simulateLoan(loanRequest), HttpStatus.CREATED);
    }
}
