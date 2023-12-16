package com.alkemy.wallet.controller;
import com.alkemy.wallet.dto.SimulateFixedTermDepositRequestDto;
import com.alkemy.wallet.dto.SimulateFixedTermDepositResponseDto;
import com.alkemy.wallet.service.FixedTermDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fixedTerm")
public class FixedTermDepositController {
    private FixedTermDepositService fixedTermDepositService;

    @Autowired
    public FixedTermDepositController(FixedTermDepositService fixedTermDepositService) {
        this.fixedTermDepositService = fixedTermDepositService;
    }
    @PostMapping("/simulate")
    public ResponseEntity<SimulateFixedTermDepositResponseDto> simulateFixedTermDeposit(@RequestBody SimulateFixedTermDepositRequestDto fixedTermRequest){
        SimulateFixedTermDepositResponseDto fixedTermResponse = fixedTermDepositService.simulateFixedTermDeposit(fixedTermRequest);
        return new ResponseEntity<>(fixedTermResponse, HttpStatus.OK);
    }
}