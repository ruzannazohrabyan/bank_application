package com.bank.transaction.bank_application.service.impl;

import com.bank.transaction.bank_application.model.Role;
import com.bank.transaction.bank_application.model.User;
import com.bank.transaction.bank_application.repository.RoleRepository;
import com.bank.transaction.bank_application.repository.UserRepository;
import com.bank.transaction.bank_application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User save(User user) {
        user.setRole(roleRepository.findById(2).get());
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<User> getById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<User> changeRole(Role role, String adminName, int userId) {
        User adminUser = getUserByName(adminName);
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            if (adminUser.getRole().getRoleName().equals("ADMIN")) {
                role.setRoleName(role.getRoleName().toUpperCase(Locale.ROOT));
                user.get().setRole(role);
                userRepository.save(user.get());
                return new ResponseEntity<>(user.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new User(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
        return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
    }

    @Override
    public User getUserByName(String firstName) {
        return userRepository.findUsersByFirstName(firstName);
    }
}
