package com.alkemy.wallet.repository;


import com.alkemy.wallet.DTO.TransactionsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionsDTO, Long> {

    List<TransactionsDTO> getTransactionsByUserId(Long id);
}
