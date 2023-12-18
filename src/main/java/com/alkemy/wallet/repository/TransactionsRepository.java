package com.alkemy.wallet.repository;


import com.alkemy.wallet.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findByAccountId(Long id);
    List<Transactions> findByAccountIdIn(List<Long> ids);


}
