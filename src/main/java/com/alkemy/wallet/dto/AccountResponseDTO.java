package com.alkemy.wallet.dto;

public class AccountResponseDTO {
    private Long aaccountId;
    private String currency;
    private Double transactionLimit;
    private Double balance;
    private String userId;

    public AccountResponseDTO(Long aaccountId, String currency, Double transactionLimit, Double balance, String userId) {
        this.aaccountId = aaccountId;
        this.currency = currency;
        this.transactionLimit = transactionLimit;
        this.balance = balance;
        this.userId = userId;
    }

    public AccountResponseDTO() {
    }

    public Long getAaccountId() {
        return aaccountId;
    }

    public void setAaccountId(Long aaccountId) {
        this.aaccountId = aaccountId;
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
