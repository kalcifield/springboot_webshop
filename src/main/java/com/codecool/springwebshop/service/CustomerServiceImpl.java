package com.codecool.springwebshop.service;


import com.codecool.springwebshop.model.Customer;
import com.codecool.springwebshop.model.Role;
import com.codecool.springwebshop.repository.CustomerRepository;
import com.codecool.springwebshop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
    public class CustomerServiceImpl implements CustomerService {
        @Autowired
        private CustomerRepository customerRepository;
        @Autowired
        private RoleRepository roleRepository;
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        @Override
        public void save(Customer customer) {
            customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
            customer.setRoles(new HashSet<Role>(roleRepository.findAll()));
            customerRepository.save(customer);
        }

        @Override
        public Customer findByUsername(String username) {
            return customerRepository.findByUsername(username);
        }
    }

