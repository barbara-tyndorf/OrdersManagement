package com.pl.OrdersManagement.address;

import com.pl.OrdersManagement.contractor.Contractor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Contractor contractor;

    @NotNull
    private String street;

    private int number;

    @NotNull
    @Size(min = 2)
    private String zip;

    @NotNull
    @Size(min = 1)
    private String city;

    @NotNull
    @Size(min = 2)
    private String countryCode;


    public Address() {
    }

    public Address(String street, int number, String zip, String city, String countryCode) {
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.city = city;
        this.countryCode = countryCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}
