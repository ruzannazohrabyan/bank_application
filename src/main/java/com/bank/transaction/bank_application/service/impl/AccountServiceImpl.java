package com.bank.transaction.bank_application.service.impl;

import com.bank.transaction.bank_application.model.Account;
import com.bank.transaction.bank_application.model.User;
import com.bank.transaction.bank_application.repository.AccountRepository;
import com.bank.transaction.bank_application.repository.UserRepository;
import com.bank.transaction.bank_application.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Account> save(String adminName, int cardHolderId) {

        Account account = new Account();
        User adminUser = userRepository.findUsersByFirstName(adminName);
        Optional<User> cardHolder = userRepository.findById(cardHolderId);
        if (cardHolder.isPresent()) {
            if (adminUser.getRole().getRoleName().equals("ADMIN")) {
                account = new Account(cardHolder.get());
                accountRepository.save(account);
                return new ResponseEntity<>(account, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(account, HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            return new ResponseEntity<>(account, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Account> getAll() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public void delete(String adminName, int cardHolderId) {
        User adminUser = userRepository.findUsersByFirstName(adminName);
        Optional<User> cardHolder = userRepository.findById(cardHolderId);
        if (cardHolder.isPresent() && adminUser.getRole().getRoleName().equals("ADMIN")) {
            accountRepository.deleteById(cardHolderId);
        }
    }
}
