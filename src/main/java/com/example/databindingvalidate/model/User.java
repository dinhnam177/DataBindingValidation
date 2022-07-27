package com.example.databindingvalidate.model;

import com.example.databindingvalidate.validated.PhoneNumberConstraint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

    @Id
    private int id;

    @NotBlank(message = "Name is can't not Blank")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "Address is can't not Blank")
    @Column(name = "address")
    private String address;
    @PhoneNumberConstraint
    @Column(name = "phone")
    @Pattern(regexp = "^0\\d{9}$", message = "Phone can't be blank!!")
    private String phone;

    public User() {
    }

    public User(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
