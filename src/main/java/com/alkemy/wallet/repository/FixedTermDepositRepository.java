package com.alkemy.wallet.repository;

import com.alkemy.wallet.model.Account;
import com.alkemy.wallet.model.FixedTermDeposit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FixedTermDepositRepository extends JpaRepository<FixedTermDeposit, Long> {
    List<FixedTermDeposit> findByAccountIn(List<Account> accounts);
}