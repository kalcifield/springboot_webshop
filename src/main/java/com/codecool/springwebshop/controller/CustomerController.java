package com.codecool.springwebshop.controller;

import com.codecool.springwebshop.model.Customer;
import com.codecool.springwebshop.repository.CustomerRepository;
import com.codecool.springwebshop.service.CustomerService;
import com.codecool.springwebshop.service.SecurityService;
import com.codecool.springwebshop.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
//public class CustomerController {
//
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    public CustomerController(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
//
//    @RequestMapping(value="/", method= RequestMethod.GET)
//    public String index(Customer customer) {
//        return "index";
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String loginForm(Customer customer) {
////        UserDBHandler userDBHandler = new UserDBHandler(userrRepository);
////        Customer customer = new Customer(username.toString(), password.toString());
//        customerRepository.save(customer);
//        return "index";
//    }




@Controller
public class CustomerController {
    @Autowired
    private CustomerService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CustomerValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Customer());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Customer userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "index";
    }
}





