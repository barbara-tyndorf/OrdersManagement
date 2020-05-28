package com.pl.OrdersManagement.order;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Order {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private long id;

    @Min(0)
    private double price;

    @NotNull
    private String currency;

    @ManyToOne
    private Contractor customer;

    public Order() {
    }

    public Order(long id, Contractor customer, double price, String currency) {
        this.id = id;
        this.customer = customer;
        this.price = price;
        this.currency = currency;
    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Contractor getCustomer() {
        return customer;
    }

    public void setCustomer(Contractor customer) {
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currenct) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", price=" + price +
                ", currency=" + currency +
                '}';
    }
}
