package com.codecool.springwebshop.repository;

import com.codecool.springwebshop.model.Customer;
import com.codecool.springwebshop.model.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long> {
}
