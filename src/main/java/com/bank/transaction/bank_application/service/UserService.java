package com.bank.transaction.bank_application.service;

import com.bank.transaction.bank_application.model.Role;
import com.bank.transaction.bank_application.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User save(User user);

    ResponseEntity<User> getById(int id);

    List<User> getAll();

    void delete(User user);

    void deleteById(int id);

    ResponseEntity<User> changeRole(Role role, String adminName, int id);

    User getUserByName(String name);
}
