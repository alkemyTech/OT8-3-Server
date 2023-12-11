package com.alkemy.wallet.repository;


import com.alkemy.wallet.DTO.TransactionsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionsDto, Long> {

    List<TransactionsDto>getTransactionsByUserId(Long id);
}
