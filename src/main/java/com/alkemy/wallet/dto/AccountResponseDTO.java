package com.alkemy.wallet.dto;

public class AccountResponseDTO {
    private String currency;
    private Double transactionLimit;
    private Double balance;
    private String userId;
    private String accountId;

    public AccountResponseDTO(String currency, Double transactionLimit, Double balance, String userId,String accountId) {
        this.currency = currency;
        this.transactionLimit = transactionLimit;
        this.balance = balance;
        this.userId = userId;
        this.accountId = accountId;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}