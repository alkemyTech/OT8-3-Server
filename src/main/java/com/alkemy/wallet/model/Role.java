package com.alkemy.wallet.model;

import com.alkemy.wallet.enums.RoleEnum;
import jakarta.persistence.*;

import java.sql.Timestamp;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @PrePersist
    protected void onCreate() {
        this.creationDate = new Timestamp(System.currentTimeMillis() );
    }
    public Role(RoleEnum name, String description, Timestamp creationDate, Timestamp updateDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}
