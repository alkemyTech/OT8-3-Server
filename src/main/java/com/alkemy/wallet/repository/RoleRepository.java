package com.alkemy.wallet.repository;

import com.alkemy.wallet.enums.RoleEnum;
import com.alkemy.wallet.model.Role;
import com.alkemy.wallet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}