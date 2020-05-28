package com.pl.OrdersManagement.order;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String street;
    private int number;
    private String zip;
    private String city;

    @ManyToOne
    private Contractor contactor;

    public Address() {
    }

    public Address(String street, int number, String zip, String city) {
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
