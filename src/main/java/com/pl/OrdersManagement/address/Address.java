package com.pl.OrdersManagement.address;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pl.OrdersManagement.contractor.Contractor;
import com.pl.OrdersManagement.order.Order;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@NotBlank
	private String name;

	@NotNull
	@NotBlank
	private String street;

	private int number;

	@NotNull
	@NotBlank
	@Size(min = 2)
	private String zip;

	@NotNull
	@NotBlank
	@Size(min = 1)
	private String city;

	@NotNull
	@NotBlank
	@Size(min = 2)
	private String countryCode;

	@ManyToOne
	private Contractor contractor;

	@ManyToOne
	private Order order;

	public Address() {
	}

	public Address(long id, String name, String street, int number, String zip,
			String city, String countryCode, Contractor contractor, Order order) {
		this.id = id;
		this.name = name;
		this.street = street;
		this.number = number;
		this.zip = zip;
		this.city = city;
		this.countryCode = countryCode;
		this.contractor = contractor;
		this.order = order;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
