package com.bank.transaction.bank_application.repository;

import com.bank.transaction.bank_application.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
