package com.bank.transaction.bank_application.service.impl;

import com.bank.transaction.bank_application.model.Account;
import com.bank.transaction.bank_application.model.Transaction;
import com.bank.transaction.bank_application.repository.AccountRepository;
import com.bank.transaction.bank_application.repository.TransactionRepository;
import com.bank.transaction.bank_application.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public ResponseEntity<Transaction> save(Transaction transaction) {
        Optional<Account> account = accountRepository.findById(transaction.getAccount().getId());
        if (account.isPresent()) {
            String action = transaction.getAction().toLowerCase(Locale.ROOT);
            if (action.equals("deposit")) {
                account.get().setFrozenAmount(transaction.getAmount());
                transaction.setStatus("PENDING");
                transactionRepository.save(transaction);
                return new ResponseEntity<>(transaction, HttpStatus.OK);
            } else if (action.equals("withdrawal")) {
                double newBalance = account.get().getBalance() - transaction.getAmount();
                if (newBalance < 0) {
                    return new ResponseEntity<>(transaction, HttpStatus.NOT_ACCEPTABLE);
                } else {
                    account.get().setBalance(newBalance);
                    account.get().setFrozenAmount(transaction.getAmount());
                    transaction.setStatus("PENDING");
                    transactionRepository.save(transaction);
                    return new ResponseEntity<>(transaction, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(transaction, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Transaction> getAll() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public List<Transaction> filterByDate(LocalDate date) {
        return null;
    }

    @Override
    public ResponseEntity<Transaction> changeStatus(int id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(transaction.isPresent() && transaction.get().getStatus().equals("PENDING")){
            Account account = transaction.get().getAccount();
            if(transaction.get().getAction().equals("deposit")){
                account.setBalance(account.getBalance() + account.getFrozenAmount());
                account.setFrozenAmount(0);
                transaction.get().setStatus("ACCEPTED");
                transactionRepository.save(transaction.get());
                return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
            } else if(transaction.get().getAction().equals("withdrawal")) {
                account.setFrozenAmount(0);
                transaction.get().setStatus("ACCEPTED");
                transactionRepository.save(transaction.get());
                return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(transaction.get(),HttpStatus.NOT_FOUND);
    }
}
