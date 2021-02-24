package com.bank.transaction.bank_application.repository;

import com.bank.transaction.bank_application.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    List<Transaction> findByDate(LocalDate date);
}
