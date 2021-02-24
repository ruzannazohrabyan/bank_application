package com.bank.transaction.bank_application.repository;

import com.bank.transaction.bank_application.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findUsersByFirstName(String firstName);
}
