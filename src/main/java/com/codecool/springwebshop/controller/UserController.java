package com.codecool.springwebshop.controller;

import com.codecool.springwebshop.model.Costumer;
import com.codecool.springwebshop.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private CostumerRepository costumerRepository;

    @Autowired
    public UserController(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Costumer costumer) {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String loginForm(Costumer costumer) {
//        UserDBHandler userDBHandler = new UserDBHandler(userrRepository);
//        Costumer costumer = new Costumer(username.toString(), password.toString());
        costumerRepository.save(costumer);
        return "index";
    }




}
