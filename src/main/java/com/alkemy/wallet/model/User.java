package com.alkemy.wallet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(length = 25, nullable = false)
    private String firstName;

    @Column(length = 25, nullable = false)
    private String lastName;

    @Column(length = 25, unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(length = 25, nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean softDelete;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    public User(String name, String username, String password, String email) {
        this.firstName = name;
        this.lastName = username;
        this.password = password;
        this.email = email;
        this.softDelete = false;
    }


    public User() {

    }
}
