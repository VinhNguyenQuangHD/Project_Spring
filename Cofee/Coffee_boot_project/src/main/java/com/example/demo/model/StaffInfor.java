package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "staff")
public class StaffInfor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40, nullable = false)
    private String staff_name;

    @Column(length = 50, nullable = false)
    private String staff_date;

    @Column(length = 10, nullable = false)
    private String staff_gender;

    @Column(length = 50, nullable = false)
    private String staff_email;

    @Column(length = 11, nullable = false)
    private String staff_phone_number;

    @Column(length = 200, nullable = false)
    private String staff_address;
}
