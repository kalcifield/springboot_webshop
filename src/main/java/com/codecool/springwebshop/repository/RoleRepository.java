package com.codecool.springwebshop.repository;

import com.codecool.springwebshop.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("role")
public interface RoleRepository extends CrudRepository<Role, Long> {
}
