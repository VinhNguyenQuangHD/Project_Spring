package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "staff")
public class StaffInfor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String staff_image;

    @Column(length = 40, nullable = false)
    private String staff_name;

    @Column(length = 10, nullable = false)
    private String staff_gender;

    @Column(length = 50, nullable = false)
    private String staff_email;

    @Column(length = 11, nullable = false)
    private String staff_phone_number;

    @Column(length = 200, nullable = false)
    private String staff_address;

    @Column(length = 200, nullable = false)
    private String staff_social_link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_gender() {
        return staff_gender;
    }

    public void setStaff_gender(String staff_gender) {
        this.staff_gender = staff_gender;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }

    public String getStaff_phone_number() {
        return staff_phone_number;
    }

    public void setStaff_phone_number(String staff_phone_number) {
        this.staff_phone_number = staff_phone_number;
    }

    public String getStaff_address() {
        return staff_address;
    }

    public void setStaff_address(String staff_address) {
        this.staff_address = staff_address;
    }

    public String getStaff_social_link() {
        return staff_social_link;
    }

    public void setStaff_social_link(String staff_social_link) {
        this.staff_social_link = staff_social_link;
    }

    public String getStaff_image() {
        return staff_image;
    }

    public void setStaff_image(String staff_image) {
        this.staff_image = staff_image;
    }
}
