package com.bank.transaction.bank_application.controller;

import com.bank.transaction.bank_application.model.Role;
import com.bank.transaction.bank_application.service.impl.RoleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final RoleServiceImpl roleServiceImpl;

    public RoleController(RoleServiceImpl roleServiceImpl) {
        this.roleServiceImpl = roleServiceImpl;
    }

    //GET /api/role -- Return all roles
    @GetMapping
    public List<Role> getAllRoles() {
        return roleServiceImpl.getAll();
    }

    //GET /api/role/{id} -- Return role with given id
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable int id) {
        return roleServiceImpl.getById(id);
    }


    //POST /api/role  -- {"id": 1, "roleName": "ADMIN"} with this format save new Role
    @PostMapping
    public Role save(@RequestBody Role role) {
        return roleServiceImpl.save(role);
    }

    //DELETE /api/role -- {"id": 1, "roleName": "ADMIN"} with this format delete existing Role
    @DeleteMapping
    public void delete(@RequestBody Role role) {
        roleServiceImpl.delete(role);
    }

    //DELETE /api/role/{id} -- delete Role with given Id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        roleServiceImpl.deleteById(id);
    }
}
