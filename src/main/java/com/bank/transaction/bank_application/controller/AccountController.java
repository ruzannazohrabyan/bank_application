package com.bank.transaction.bank_application.controller;

import com.bank.transaction.bank_application.model.Account;
import com.bank.transaction.bank_application.service.impl.AccountServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountServiceImpl accountServiceImpl;

    public AccountController(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;
    }

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountServiceImpl.getAll();
    }

    @GetMapping("/{adminName}/create/{cardHolderId}")
    public ResponseEntity<Account> save(@PathVariable String adminName, @PathVariable int cardHolderId) {
        return accountServiceImpl.save(adminName, cardHolderId);
    }

    @DeleteMapping("/{adminName}/delete/{cardHolderId}")
    public void delete(@PathVariable String adminName, @PathVariable int cardHolderId) {
        accountServiceImpl.delete(adminName, cardHolderId);
    }
}
