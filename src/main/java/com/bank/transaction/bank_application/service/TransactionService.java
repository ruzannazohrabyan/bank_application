package com.bank.transaction.bank_application.service;

import com.bank.transaction.bank_application.model.Transaction;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionService {
    ResponseEntity<Transaction> save(Transaction transaction);
    List<Transaction> getAll();
}
