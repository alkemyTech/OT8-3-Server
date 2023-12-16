package com.alkemy.wallet.dto;

public class AccountUpdateDTO {
    private Long accountId;
    private Double transactionLimit;
    private String userAuthenticated;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(Double transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public String getUserAuthenticated() {
        return userAuthenticated;
    }

    public void setUserAuthenticated(String userAuthenticated) {
        this.userAuthenticated = userAuthenticated;
    }
}
