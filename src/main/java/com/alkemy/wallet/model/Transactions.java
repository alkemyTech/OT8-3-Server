package com.alkemy.wallet.model;

import com.alkemy.wallet.enums.TypeEnum;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.Date;

@Entity
@Data
public class Transactions {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column( nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    private TypeEnum typeEnum;

    @Column(nullable = false)
    private String description;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "account_Id", referencedColumnName = "Id")
     private Account account;

    public Transactions(Double amount, TypeEnum typeEnum, String description, Date transactionDate){
     this.amount = amount;
     this.typeEnum = typeEnum;
     this.description = description;
     this.transactionDate= transactionDate;
 }
public Transactions(){

}
}