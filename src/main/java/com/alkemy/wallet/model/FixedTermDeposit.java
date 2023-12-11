package com.alkemy.wallet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class FixedTermDeposit {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable= false)
    private Double amount;

    @Column(nullable = false)
    private Double interest;

    @Column
    private Timestamp creationDate;

    @Column
    private Timestamp closingDate;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "Id")
    private Account account;

    public FixedTermDeposit(Double amount, Double interest, Timestamp creationDate, Timestamp closingDate) {
        this.amount = amount;
        this.interest = interest;
        this.creationDate = creationDate;
        this.closingDate = closingDate;
    }

    public FixedTermDeposit() {

    }
}
