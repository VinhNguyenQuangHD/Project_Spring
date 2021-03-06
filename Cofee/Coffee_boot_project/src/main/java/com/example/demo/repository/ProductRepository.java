package com.example.demo.repository;

import com.example.demo.model.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Production,Integer> {
    public Long countById(Integer id);
}

