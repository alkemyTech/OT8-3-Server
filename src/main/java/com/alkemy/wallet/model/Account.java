package com.alkemy.wallet.model;

import com.alkemy.wallet.enums.CurrencyEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum currencyEnum;

    @Column(nullable = false)
    private Double transactionLimit;

    @Column(nullable = false)
    private Double balance;

    @Column
    private Timestamp creationDate;

    @Column
    private Timestamp updateDate;

    @OneToMany(mappedBy = "account")
    private List <Transactions> transactions;

    @OneToMany(mappedBy = "account")
    private List<FixedTermDeposit> fixedTermDeposits;

    @ManyToOne
    @JoinColumn(name="User_Id", referencedColumnName = "ID")
    private User user;

    @Column
    private Boolean softDelete = false;

    @PrePersist
    protected void onCreate(){
        this.creationDate = new Timestamp(System.currentTimeMillis());
        this.updateDate = new Timestamp(System.currentTimeMillis());
    }
    @PreUpdate
    protected void onUpdate(){
        this.updateDate = new Timestamp(System.currentTimeMillis());
    }
    public Account(User user, CurrencyEnum currencyEnum, Double transactionLimit) {
        this.user = user;
        this.currencyEnum = currencyEnum;
        this.transactionLimit = transactionLimit;
        this.balance = 0.0;
    }

    public Account() {

    }
}


