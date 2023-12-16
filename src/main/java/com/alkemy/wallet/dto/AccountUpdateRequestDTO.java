package com.alkemy.wallet.dto;

public class AccountUpdateRequestDTO {
    private Double transactionLimit;
    private String userAuthenticated;


    public Double getTransactionLimit() {
        return transactionLimit;
    }

    public String getUserAuthenticated() {
        return userAuthenticated;
    }
    public void setUserAuthenticated(String userAuthenticated) {
        this.userAuthenticated = userAuthenticated;
    }
}