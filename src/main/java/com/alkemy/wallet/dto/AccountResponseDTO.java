package com.alkemy.wallet.dto;

public class AccountResponseDTO {
    private String currency;
    private Double transactionLimit;
    private Double balance;
    private String userId;

    public AccountResponseDTO(String currency, Double transactionLimit, Double balance, String userId) {
        this.currency = currency;
        this.transactionLimit = transactionLimit;
        this.balance = balance;
        this.userId = userId;
    }

    public AccountResponseDTO() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(Double transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
