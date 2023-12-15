package com.alkemy.wallet.dto;
public class AccountRequestDTO {
    private String currency;
    private String userAuthenticated;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUserAuthenticated() {
        return userAuthenticated;
    }

    public void setUserAuthenticated(String userAuthenticated) {
        this.userAuthenticated = userAuthenticated;
    }
}
