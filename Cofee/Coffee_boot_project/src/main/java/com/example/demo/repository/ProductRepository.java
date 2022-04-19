package com.example.demo.repository;

import com.example.demo.model.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Production,Integer> {
    @Query("Select a from Production a, Types t where a.types = t")
    public List<Production> findByList();
}

