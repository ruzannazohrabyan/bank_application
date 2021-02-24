package com.bank.transaction.bank_application.service.impl;

import com.bank.transaction.bank_application.model.Role;
import com.bank.transaction.bank_application.repository.RoleRepository;
import com.bank.transaction.bank_application.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role){
        return roleRepository.save(role);
    }

    @Override
    public ResponseEntity<Role> getById(int id) {
        Optional<Role> role = roleRepository.findById(id);

        if(role.isPresent()){
            return new ResponseEntity<>(role.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Role(), HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Role> getAll() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }
}
