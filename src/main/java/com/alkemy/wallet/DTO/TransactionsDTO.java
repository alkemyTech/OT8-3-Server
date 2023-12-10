package com.alkemy.wallet.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionsDTO {
    private Long accountId;
    private Long transactionId;
    private double amount;
    private String type;
    private String description;
    private Date transactionDate;

    public TransactionsDTO(Long id, Long id1, Double amount, String name, String description, Date transactionDate) {
    }
}
