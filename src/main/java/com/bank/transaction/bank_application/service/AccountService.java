package com.bank.transaction.bank_application.service;

import com.bank.transaction.bank_application.model.Account;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface AccountService {

    ResponseEntity<Account> save(String adminName, int cardHolderId);
    List<Account> getAll();
    void delete(String adminName, int cardHolderId);
}
