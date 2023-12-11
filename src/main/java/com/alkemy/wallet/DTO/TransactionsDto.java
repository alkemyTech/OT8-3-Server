package com.alkemy.wallet.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.alkemy.wallet.model.Transactions}
 */

@Data
public class TransactionsDto implements Serializable {
    private Double amount;
    private String typeEnum;
    private String description;
    private Date transactionDate;
    private Long accountId;
    private Long transactionId;

    public TransactionsDto(Long id, Long id1, Double amount, String name, String description, Date transactionDate) {
    }
}