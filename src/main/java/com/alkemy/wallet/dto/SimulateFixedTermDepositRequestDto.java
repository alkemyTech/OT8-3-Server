package com.alkemy.wallet.dto;

public class SimulateFixedTermDepositRequestDto {
    Double amount;
    Integer days;

    public SimulateFixedTermDepositRequestDto(Double amount, Integer days) {
        this.amount = amount;
        this.days = days;
    }

    public SimulateFixedTermDepositRequestDto() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}
