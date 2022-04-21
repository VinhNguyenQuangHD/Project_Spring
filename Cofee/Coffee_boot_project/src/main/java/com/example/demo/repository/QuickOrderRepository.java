package com.example.demo.repository;

import com.example.demo.model.QuickOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuickOrderRepository extends JpaRepository<QuickOrder,Integer> {
}
