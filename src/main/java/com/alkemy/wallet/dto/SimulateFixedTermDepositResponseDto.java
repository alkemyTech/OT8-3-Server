package com.alkemy.wallet.dto;

import java.sql.Timestamp;

public class SimulateFixedTermDepositResponseDto {
    private Double investedAmount;
    private Timestamp creationDate;
    private Timestamp closingDate;
    private Double totalInterest;
    private Double totalValue;

    public SimulateFixedTermDepositResponseDto(Double investedAmount, Timestamp creationDate, Timestamp closingDate, Double totalInterest, Double totalValue) {
        this.investedAmount = investedAmount;
        this.creationDate = creationDate;
        this.closingDate = closingDate;
        this.totalInterest = totalInterest;
        this.totalValue = totalValue;
    }

    public SimulateFixedTermDepositResponseDto() {
    }

    public Double getInvestedAmount() {
        return investedAmount;
    }

    public void setInvestedAmount(Double investedAmount) {
        this.investedAmount = investedAmount;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Timestamp closingDate) {
        this.closingDate = closingDate;
    }

    public Double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(Double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
