package com.alkemy.wallet.dto;

import lombok.Getter;

@Getter
public class AccountUpdateResponseDTO {
    private Double newTransactionLimit;


    public void setNewTransactionLimit(Double newTransactionLimit) {

        this.newTransactionLimit = newTransactionLimit;
    }

}
