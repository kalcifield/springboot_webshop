package com.codecool.springwebshop.repository;


import com.codecool.springwebshop.model.Costumer;
import org.springframework.data.repository.CrudRepository;

public interface CostumerRepository extends CrudRepository<Costumer, Long> {
    Costumer findById(int Id);
}
