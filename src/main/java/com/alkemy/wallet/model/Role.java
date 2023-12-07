package com.alkemy.wallet.model;

import com.alkemy.wallet.enums.RoleEnum;
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
    private RoleEnum name;

    @Column
    private String description;

    @Column
    private Timestamp creationDate;

    @Column
    private Timestamp updateDate;

    public Role(RoleEnum name, String description, Timestamp creationDate, Timestamp updateDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Role() {

    }
}
