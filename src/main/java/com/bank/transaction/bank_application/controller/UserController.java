package com.bank.transaction.bank_application.controller;

import com.bank.transaction.bank_application.model.Role;
import com.bank.transaction.bank_application.model.User;
import com.bank.transaction.bank_application.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/register")
    public User save(@RequestBody User user) {
        return userServiceImpl.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userServiceImpl.getById(id);
    }

    @PutMapping("/{adminName}/{userId}/role")
    public ResponseEntity<User> changeRole(@RequestBody Role role, @PathVariable String adminName, @PathVariable int userId) {
        return userServiceImpl.changeRole(role, adminName, userId);
    }

}
