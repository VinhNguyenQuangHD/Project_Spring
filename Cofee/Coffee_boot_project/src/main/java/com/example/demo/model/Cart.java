package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String production_image;

    @Column(nullable = false, length = 100)
    private String production_name;

    @Column(nullable = false, length = 100)
    private String production_price;

    @Column(nullable = false, length = 100)
    private String production_count;

    @Column(nullable = false, length = 100)
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getProduction_image() {
        return production_image;
    }

    public void setProduction_image(String production_image) {
        this.production_image = production_image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduction_name() {
        return production_name;
    }

    public void setProduction_name(String production_name) {
        this.production_name = production_name;
    }

    public String getProduction_price() {
        return production_price;
    }

    public void setProduction_price(String production_price) {
        this.production_price = production_price;
    }

    public String getProduction_count() {
        return production_count;
    }

    public void setProduction_count(String production_count) {
        this.production_count = production_count;
    }
}
