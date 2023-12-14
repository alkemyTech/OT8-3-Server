package com.alkemy.wallet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class User implements UserDetails {

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

    @OneToMany
    private List<Account> account;

    public User(String name, String username, String password, String email) {
        this.firstName = name;
        this.lastName = username;
        this.password = password;
        this.email = email;
        this.softDelete = false;
    }


    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ADMIN"));   //TODO aca tengo que agregar ROLE despues de hacer el import multitabla
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
