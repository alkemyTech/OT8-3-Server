package com.alkemy.wallet.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private com.alkemy.wallet.enums.Role name;

    @Column
    private String description;

    @Column
    private Timestamp creationDate;

    @Column
    private Timestamp updateDate;

    public Role(com.alkemy.wallet.enums.Role name, String description, Timestamp creationDate, Timestamp updateDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Role() {

    }
}
