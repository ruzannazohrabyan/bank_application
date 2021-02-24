package com.bank.transaction.bank_application.service;

import com.bank.transaction.bank_application.model.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {

    Role save(Role role);

    ResponseEntity<Role> getById(int id);

    List<Role> getAll();

    void delete(Role role);

    void deleteById(int id);

}
