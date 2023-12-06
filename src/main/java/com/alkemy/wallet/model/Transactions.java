package com.alkemy.wallet.model;

import com.alkemy.wallet.enums.Type;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.Date;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column( nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private String description;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "Id")
     private Account account;

    public Transactions(Double amount, Type type, String description, Date transactionDate){
     this.amount = amount;
     this.type = type;
     this.description = description;
     this.transactionDate= transactionDate;
 }
public Transactions(){

}
}