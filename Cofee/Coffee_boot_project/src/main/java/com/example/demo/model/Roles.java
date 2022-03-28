package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_role;

    @Column(nullable = false,length = 20)
    private String role;

    @Column(nullable = false, length = 25)
    private String des;
}
