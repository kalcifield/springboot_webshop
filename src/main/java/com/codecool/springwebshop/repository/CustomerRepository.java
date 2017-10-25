package com.codecool.springwebshop.repository;


import com.codecool.springwebshop.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findById(int Id);
    Customer findByUsername(String username);
}
