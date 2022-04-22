package com.example.demo.repository;

import com.example.demo.model.StaffInfor;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffInforRepository extends JpaRepository<StaffInfor,Integer> {
    @Query("SELECT u FROM StaffInfor u WHERE u.staff_email = ?1")
    public StaffInfor findByEmail(String staff_email);
}
