package com.alkemy.wallet.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

@Entity
@Data

public class Transactions {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column( nullable = false)
    private Double amount;

    private enum type{ INCOME, PAYMENT, DEPOSIT};
    @Enumerated(EnumType.STRING)
    private Enum type;

    @Column(nullable = false)
    private String description;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name="account",referencedColumnName = "Id")
    private Account account;

 public Transactions(Double amount, Enum type, String description, Date transactionDate){
     this.amount = amount;
     this.type = type;
     this.description = description;
     this.transactionDate= transactionDate;
 }
public Transactions(){

}
}