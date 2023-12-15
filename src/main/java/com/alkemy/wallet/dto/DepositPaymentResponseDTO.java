package com.alkemy.wallet.dto;

public class DepositPaymentResponseDTO {
    private String accountId;
    private TransactionDTO transaction;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public TransactionDTO getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionDTO transaction) {
        this.transaction = transaction;
    }
}
