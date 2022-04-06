package com.example.demo.repository;

import com.example.demo.model.Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesRepository extends JpaRepository<Types,Integer> {
}
