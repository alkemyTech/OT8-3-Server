package com.alkemy.wallet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class FixedTermDeposit {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable= false)
    private Double amount;

    @Column(nullable = false)
    private Double interest;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column
    private Timestamp closingDate;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "Id")
    private Account account;

    public FixedTermDeposit(Double amount, Double interest, Timestamp creationDate, Timestamp closingDate, Account account) {
        this.amount = amount;
        this.interest = interest;
        this.creationDate = creationDate;
        this.closingDate = closingDate;
        this.account = account;
    }

    public FixedTermDeposit() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Timestamp closingDate) {
        this.closingDate = closingDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
