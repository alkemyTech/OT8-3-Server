package com.alkemy.wallet.service;

import com.alkemy.wallet.dto.FixedTermDepositRequestDto;
import com.alkemy.wallet.dto.FixedTermDepositResponseDto;
import com.alkemy.wallet.repository.FixedTermDepositRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class FixedTermDepositService {
    private FixedTermDepositRepository fixedTermDepositRepository;

    public FixedTermDepositService(FixedTermDepositRepository fixedTermDepositRepository) {
        this.fixedTermDepositRepository = fixedTermDepositRepository;
    }

    public FixedTermDepositResponseDto simulateFixedTermDeposit(FixedTermDepositRequestDto fixedTermDepositRequestDto) {
        double amount = fixedTermDepositRequestDto.getAmount();
        int days = fixedTermDepositRequestDto.getDays();
        if(amount > 0.0 && days > 0){
            return calculateFixedTermDeposit(amount,days);
        }
        return null;
    }

    private FixedTermDepositResponseDto calculateFixedTermDeposit(Double amount, int days) {
        double interestRate = 0.002;
        double interestPerDay =  amount * interestRate;
        double totalInterest = interestPerDay * days;
        double totalValue = amount + totalInterest;
        Timestamp creationDate = new Timestamp(new Date().getTime());
        Timestamp closingDate = new Timestamp(new Date().getTime() + (long) days * 24 * 60 * 60 * 1000);
        return new FixedTermDepositResponseDto(
                amount,
                creationDate,
                closingDate,
                totalInterest,
                totalValue
        );
    }
    public FixedTermDepositResponseDto fixedTermDeposit(FixedTermDepositRequestDto fixedTermDepositRequestDto) {
        double amount = fixedTermDepositRequestDto.getAmount();
        int days = fixedTermDepositRequestDto.getDays();
        if(amount > 0.0 && days > 0){
            return calculateFixedTermDeposit(amount,days);
        }
        return null;
    }
}