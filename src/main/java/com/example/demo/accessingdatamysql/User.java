package com.example.demo.accessingdatamysql;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.Period;

@Entity
@Table (name = "members")
public class User {

    @Transient // means that this field doesn't need to be column in database
    private Integer age;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PersonID")
    private Integer personID;


    public Integer getPersonId() {
        return personID;
    }

    public void setPersonId(Integer personId) {
        this.personID = personId;
    }

    @Column(name = "LastName")
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "FirstName")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "Address")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "City")
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "FreePass")
    private Boolean freePass;

    public Boolean getFreePass() {
        return freePass;
    }

    public void setFreePass(Boolean freePass) {
        this.freePass = freePass;
    }

    @Column(name = "Fee")
    private Float fee;

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }


    @Column(name = "Birth_Date")
    private LocalDate birthDate;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    public void setAge(Integer age){
        this.age = age;
    }

    @Column(name = "Squat")
    private Integer squat;

    public Integer getSquat() {
        return squat;
    }

    public void setSquat(Integer squat) {
        this.squat = squat;
    }

    @Column(name = "Deadlift")
    private Integer deadlift;

    public Integer getDeadlift() {
        return deadlift;
    }

    public void setDeadlift(Integer deadlift) {
        this.deadlift = deadlift;
    }

    @Column(name = "Bench")
    private Integer bench;

    public Integer getBench() {
        return bench;
    }

    public void setBench(Integer bench) {
        this.bench = bench;
    }

    @Column(name = "Height")
    private String height;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
//
//    public User() {}
//
//    public User(Integer age, Integer personID, String lastName, String firstName, String address, String city, Boolean freePass, Float fee, LocalDate birthDate, Integer squat, Integer deadlift, Integer bench, String height) {
//        this.age = age;
//        this.personID = personID;
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.address = address;
//        this.city = city;
//        this.freePass = freePass;
//        this.fee = fee;
//        this.birthDate = birthDate;
//        this.squat = squat;
//        this.deadlift = deadlift;
//        this.bench = bench;
//        this.height = height;
//    }

}