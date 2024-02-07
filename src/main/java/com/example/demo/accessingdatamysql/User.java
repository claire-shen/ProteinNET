package com.example.demo.accessingdatamysql;

import jakarta.persistence.*;

@Entity
@Table (name = "List")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer PersonId;
    private Integer Age;
    private String LastName;
    private String FirstName;
    private String Address;
    private String City;
    private Boolean FreePass;
    private Float Fee;

    public User(Integer personId, Integer age, String lastName, String firstName, String address, String city, Boolean freePass, Float fee) {
        PersonId = personId;
        Age = age;
        LastName = lastName;
        FirstName = firstName;
        Address = address;
        City = city;
        FreePass = freePass;
        Fee = fee;
    }

    public Integer getPersonId() {
        return PersonId;
    }

    public void setPersonId(Integer personId) {
        PersonId = personId;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Boolean getFreePass() {
        return FreePass;
    }

    public void setFreePass(Boolean freePass) {
        FreePass = freePass;
    }

    public Float getFee() {
        return Fee;
    }

    public void setFee(Float fee) {
        Fee = fee;
    }
}