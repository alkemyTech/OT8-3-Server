package com.alkemy.wallet.controller;
import com.alkemy.wallet.dto.FixedTermDepositRequestDto;
import com.alkemy.wallet.dto.FixedTermDepositResponseDto;
import com.alkemy.wallet.service.FixedTermDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ResponseEntity<FixedTermDepositResponseDto> simulateFixedTermDeposit(@RequestBody FixedTermDepositRequestDto fixedTermRequest){
        FixedTermDepositResponseDto fixedTermResponse = fixedTermDepositService.simulateFixedTermDeposit(fixedTermRequest);
        return new ResponseEntity<>(fixedTermResponse, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<FixedTermDepositResponseDto> fixedTermDeposit(@RequestBody FixedTermDepositRequestDto fixedTermRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        FixedTermDepositResponseDto fixedTermResponse = fixedTermDepositService.fixedTermDepositOK(fixedTermRequest, authentication.getName());
        return new ResponseEntity<>(fixedTermResponse, HttpStatus.OK);
    }

}