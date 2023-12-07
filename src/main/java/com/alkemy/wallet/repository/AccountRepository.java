package com.alkemy.wallet.repository;

import com.alkemy.wallet.dto.AccountDto;
import com.alkemy.wallet.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<AccountDto> getAccountsByUserId(Long id);
}