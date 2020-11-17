package com.pl.OrdersManagement.address;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Column(name = "name")
	private String name;

	@NotBlank
	@Column(name = "street")
	private String street;

	@Column(name = "number")
	private Integer number;

	@NotBlank
	@Size(min = 2)
	@Column(name = "zip")
	private String zip;

	@NotBlank
	@Size(min = 1)
	@Column(name = "city")
	private String city;

	@NotBlank
	@Size(min = 1)
	@Column(name = "country_code")
	private String countryCode;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Address address = (Address) o;
		return Objects.equals(id, address.id) &&
				Objects.equals(name, address.name) &&
				Objects.equals(street, address.street) &&
				Objects.equals(number, address.number) &&
				Objects.equals(zip, address.zip) &&
				Objects.equals(city, address.city) &&
				Objects.equals(countryCode, address.countryCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, street, number, zip, city, countryCode);
	}

	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", name='" + name + '\'' +
				", street='" + street + '\'' +
				", number=" + number +
				", zip='" + zip + '\'' +
				", city='" + city + '\'' +
				", countryCode='" + countryCode + '\'' +
				'}';
	}
}
