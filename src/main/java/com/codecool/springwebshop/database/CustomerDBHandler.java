//package com.codecool.springwebshop.database;
//
//import com.codecool.springwebshop.model.Customer;
//import com.codecool.springwebshop.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Deprecated
//@Repository
//public class CustomerDBHandler {
//
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    public CustomerDBHandler(CustomerRepository customerRepository){
//        this.customerRepository = customerRepository;
//        System.out.println("EEEEE" + customerRepository);
//        deleteAll();
////        saveUsersEntity(new Customer("xdani79", "admin123"));
//        saveUsersEntity(new Customer("xxxxx", "admin123"));
//    }
//
//    public void deleteAll(){
//        customerRepository.deleteAll();
//    }
//
//    public void saveUsersEntity(Customer customer){
//        customerRepository.save(customer);
//    }
//}
