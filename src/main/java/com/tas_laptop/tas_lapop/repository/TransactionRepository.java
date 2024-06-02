package com.tas_laptop.tas_lapop.repository;

import com.tas_laptop.tas_lapop.entity.Transaction;
import com.tas_laptop.tas_lapop.entity.TransactionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT ti " +
        "FROM Transaction t " +
        "JOIN TransactionItem ti ON t.id = ti.id.transaction.id " +
        "WHERE t.time between :startTime AND :endTime")
    List<TransactionItem> getTransactionItems(LocalDateTime startTime, LocalDateTime endTime);

}
