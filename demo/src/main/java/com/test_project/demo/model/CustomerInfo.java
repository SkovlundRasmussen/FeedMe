package com.test_project.demo.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class CustomerInfo {

    @Id
    @Column(name = "user_id")
    int userId;
    @Column(name = "street_name")
    String streetName;
    @Column(name = "street_number")
    String streetNumber;
    @Column(name = "postal_code")
    int postalCode;
    @Column(name = "city")
    String city;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}