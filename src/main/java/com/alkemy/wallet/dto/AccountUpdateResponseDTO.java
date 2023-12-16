package com.alkemy.wallet.dto;


public class AccountUpdateResponseDTO {
    private Double newTransactionLimit;

    public AccountUpdateResponseDTO(Double newTransactionLimit) {
        this.newTransactionLimit = newTransactionLimit;
    }

    public AccountUpdateResponseDTO() {
    }

    public Double getNewTransactionLimit() {
        return newTransactionLimit;
    }

    public void setNewTransactionLimit(Double newTransactionLimit) {
        this.newTransactionLimit = newTransactionLimit;
    }
}
