package com.alkemy.wallet.service;

import com.alkemy.wallet.dto.LoanRequestDTO;
import com.alkemy.wallet.dto.LoanResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private static final Double INTEREST = 0.05;
 public LoanResponseDTO simulateLoan(LoanRequestDTO loanRequest){
     Double amountInstallments = (((loanRequest.getAmount() * INTEREST) *  loanRequest.getInstallments()) + loanRequest.getAmount()) / loanRequest.getInstallments();
     Double totalAmount = amountInstallments * loanRequest.getInstallments();
     String interestRate = "%" + (INTEREST * 100);
     return new LoanResponseDTO(amountInstallments, totalAmount, interestRate);
 }
}
