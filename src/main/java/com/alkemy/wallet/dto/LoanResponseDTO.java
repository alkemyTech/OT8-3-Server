package com.alkemy.wallet.dto;

public class LoanResponseDTO {
    private Double amountInstallments;
    private Double totalAmount;
    private String interestRate;

    public LoanResponseDTO(Double amountInstallments, Double totalAmount, String interestRate) {
        this.amountInstallments = amountInstallments;
        this.totalAmount = totalAmount;
        this.interestRate = interestRate;
    }

    public LoanResponseDTO() {
    }

    public Double getAmountInstallments() {
        return amountInstallments;
    }

    public void setAmountInstallments(Double amountInstallments) {
        this.amountInstallments = amountInstallments;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }
}
