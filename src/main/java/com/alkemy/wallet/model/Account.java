package com.alkemy.wallet.model;

import com.alkemy.wallet.enums.Currency;
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
    private Currency currency;

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
    @JoinColumn(name="user_Id", referencedColumnName = "Id")
    private User user;

    @Column
    private Boolean softDelete = false;

    public Account(Currency currency, Double transactionLimit, Double balance, Timestamp creationDate, Timestamp updateDate) {
        this.currency = currency;
        this.transactionLimit = transactionLimit;
        this.balance = balance;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Account() {

    }
}


