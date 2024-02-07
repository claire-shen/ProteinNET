package com.example.demo.accessingdatamysql;

import jakarta.persistence.*;

@Entity
@Table (name = "members")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "PersonID")
    private Integer personID;

    public Integer getPersonId() {
        return personID;
    }

    public void setPersonId(Integer personId) {
        this.personID = personId; // Corrected variable assignment
    }


    @Column(name = "Age")
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}
