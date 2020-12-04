package com.pl.OrdersManagement.contractor;

import com.pl.OrdersManagement.address.Address;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Objects;

import lombok.Data;

@Data
@Entity
@Table(name = "contractor")
public class Contractor {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

//	@NotBlank
	@Size(min = 2)
	@Column(name = "name")
	private String name;

/*	@OneToOne
	@JoinColumn(unique = true)
	private Address address;*/

//	@NotBlank
	@Size(min = 2)
	@Column(name = "street")
	private String street;

	@Column(name = "number")
	private Integer number;

	@NotBlank
	@Size(min = 2)
	@Column(name = "zip")
	private String zip;

	@NotBlank
	@Column(name = "city")
	private String city;

	@NotBlank
	@Size(min = 2)
	@Column(name = "countryCode")
	private String countryCode;

	@NotBlank
	@Pattern(regexp = "^(ATU[0-/9]{8}|BE[01][0-9]{9}|BG[0-9]{9,10}|HR[0-9]{11}|CY[A-Z0-9]{9}|CZ[0-9]{8,10}|DK[0-9]{8}|EE[0-9]{9}|FI[0-9]{8}|FR[0-9A-Z]{2}[0-9]{9}|DE[0-9]{9}|EL[0-9]{9}|HU[0-9]{8}|IE([0-9]{7}[A-Z]{1,2}|[0-9][A-Z][0-9]{5}[A-Z])|IT[0-9]{11}|LV[0-9]{11}|LT([0-9]{9}|[0-9]{12})|LU[0-9]{8}|MT[0-9]{8}|NL[0-9]{9}B[0-9]{2}|PL[0-9]{10}|PT[0-9]{9}|RO[0-9]{2,10}|SK[0-9]{10}|SI[0-9]{8}|ES[A-Z]([0-9]{8}|[0-9]{7}[A-Z])|SE[0-9]{12}|GB([0-9]{9}|[0-9]{12}|GD[0-4][0-9]{2}|HA[5-9][0-9]{2}))$\n")
	@Column(name = "vat_id")
	private String vatId;

	@Column(name = "contact_person")
	private String contactPerson;

	@NotBlank
	@Column(name = "phone_number")
	private String phoneNumber;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Contractor that = (Contractor) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(name, that.name) &&
				Objects.equals(street, that.street) &&
				Objects.equals(number, that.number) &&
				Objects.equals(zip, that.zip) &&
				Objects.equals(city, that.city) &&
				Objects.equals(countryCode, that.countryCode) &&
				Objects.equals(vatId, that.vatId) &&
				Objects.equals(contactPerson, that.contactPerson) &&
				Objects.equals(phoneNumber, that.phoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, street, number, zip, city, countryCode, vatId, contactPerson, phoneNumber);
	}

	@Override
	public String toString() {
		return "Contractor{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", street='" + street + '\'' +
				", number='" + number + '\'' +
				", zip='" + zip + '\'' +
				", city='" + city + '\'' +
				", countryCode='" + countryCode + '\'' +
				", vatId='" + vatId + '\'' +
				", contactPerson='" + contactPerson + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				'}';
	}
}
