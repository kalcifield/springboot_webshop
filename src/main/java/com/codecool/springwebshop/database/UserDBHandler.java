package com.codecool.springwebshop.database;

import com.codecool.springwebshop.model.Costumer;
import com.codecool.springwebshop.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDBHandler {

    private CostumerRepository costumerRepository;

    @Autowired
    public UserDBHandler(CostumerRepository costumerRepository){
        this.costumerRepository = costumerRepository;
        System.out.println("EEEEE" + costumerRepository);
        deleteAll();
//        saveUsersEntity(new Costumer("xdani79", "admin123"));
        saveUsersEntity(new Costumer("xxxxx", "admin123"));
    }

    public void deleteAll(){
        costumerRepository.deleteAll();
    }

    public void saveUsersEntity(Costumer costumer){
        costumerRepository.save(costumer);
    }
}
