package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerInfor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String customer_name;

    @Column(length = 10, nullable = false)
    private Long customer_ages;

    @Column(length = 10, nullable = false)
    private String customer_gender;

    @Column(length = 11, nullable = false)
    private String customer_phone;

    @Column(length = 200, nullable = false)
    private String customer_address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Long getCustomer_ages() {
        return customer_ages;
    }

    public void setCustomer_ages(Long customer_ages) {
        this.customer_ages = customer_ages;
    }

    public String getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(String customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }
}
