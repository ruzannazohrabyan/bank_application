package com.bank.transaction.bank_application.controller;

import com.bank.transaction.bank_application.model.Transaction;
import com.bank.transaction.bank_application.service.impl.TransactionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionServiceImpl transactionServiceImpl;

    public TransactionController(TransactionServiceImpl transactionServiceImpl) {
        this.transactionServiceImpl = transactionServiceImpl;
    }

    /*
    {
        "account": {
            "id": 1,
            "balance": 0.0,
            "cardHolder": {
                "id": 6,
                "firstName": "Erik",
                "lastName": "Martirosyan",
                "password": "passwordErik",
                "email": "erkaru2010@gmail.com",
                "role": {
                    "id": 2,
                    "roleName": "USER"
                }
            }
        },
        "amount": 1000,
        "action": "deposit"
    }
     */
    @PostMapping
    public ResponseEntity<Transaction> save(@RequestBody Transaction transaction){
        return transactionServiceImpl.save(transaction);
    }

    /*
    /api/transaction/1
     */
    @PatchMapping("/{transactionId}")
    public ResponseEntity<Transaction> changeStatus(@PathVariable int transactionId){
        return transactionServiceImpl.changeStatus(transactionId);
    }
    @GetMapping
    public List<Transaction> getAllTransaction(){
        return transactionServiceImpl.getAll();
    }
}
