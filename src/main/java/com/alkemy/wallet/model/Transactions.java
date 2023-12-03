package com.alkemy.wallet.model;

import lombok.Data;
import jakarta.persistence.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import java.util.Date;

@Entity
@Table(name = "Transactions")
@Data

public class Transactions {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

    private enum Type{ INCOME, PAYMENT, DEPOSIT};
    @Enumerated (EnumType.STRING)
    private Enum type;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "TRANSACTION DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

 public Transactions(Double amount, Enum type, String description, Date transactionDate){
     this.amount = amount;
     this.type = type;
     this.description = description;
     this.transactionDate= transactionDate;
 }

public Transactions(){

}
}