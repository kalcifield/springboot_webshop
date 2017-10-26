package com.codecool.springwebshop.service;


import com.codecool.springwebshop.model.Customer;
//import com.codecool.springwebshop.model.Role;
import com.codecool.springwebshop.model.Role;
import com.codecool.springwebshop.repository.CustomerRepository;
//import com.codecool.springwebshop.repository.RoleRepository;
import com.codecool.springwebshop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(Customer customer) {
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));

//        I dunno what happens but it might work
        customer.setRoles(new HashSet<>((Collection<? extends Role>) roleRepository.findAll()));
        customerRepository.save(customer);
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }
}

