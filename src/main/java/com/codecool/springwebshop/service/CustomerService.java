package com.codecool.springwebshop.service;

import com.codecool.springwebshop.model.Customer;

/**
 * Created by majoross on 2017.10.25..
 */
public interface CustomerService {
    void save(Customer customer);

     Customer findByUsername(String username);
}
