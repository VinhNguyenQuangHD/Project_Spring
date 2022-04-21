package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "quick_order")
public class QuickOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @Column(nullable = false, length = 100)
    private String date;

    @Column(nullable = false, length = 100)
    private String guest_name;

    @Column(nullable = false, length = 100)
    private String order_content;

    @Column(nullable = false, length = 100)
    private String payment;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public String getOrder_content() {
        return order_content;
    }

    public void setOrder_content(String order_content) {
        this.order_content = order_content;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
