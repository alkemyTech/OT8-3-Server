package com.alkemy.wallet.dto;

public class FixedTermDepositRequestDto {
    Double amount;
    Integer days;

    public FixedTermDepositRequestDto(Double amount, Integer days) {
        this.amount = amount;
        this.days = days;
    }

    public FixedTermDepositRequestDto() {
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
