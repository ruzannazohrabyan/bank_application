package com.bank.transaction.bank_application.repository;

import com.bank.transaction.bank_application.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
