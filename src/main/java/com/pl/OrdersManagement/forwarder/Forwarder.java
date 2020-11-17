package com.pl.OrdersManagement.forwarder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.pl.OrdersManagement.enumeration.Branch;
import com.pl.OrdersManagement.order.Order;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "forwarder")
public class Forwarder {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z\\s]*$")
	@Column(name = "first_name")
	private String firstName;

	@Pattern(regexp = "^[a-zA-Z\\s]*$")
	@Column(name = "last_name")
	private String lastName;

	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "hire_date")
	private Instant hireDate;

	@Column(name = "salary")
	private Long salary;

	@Enumerated(EnumType.STRING)
	@Column(name = "branch")
	private Branch branch;

	@OneToMany(mappedBy = "forwarder")
//	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Order> orders = new HashSet<>();

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Forwarder forwarder = (Forwarder) o;
		return Objects.equals(id, forwarder.id) &&
				Objects.equals(firstName, forwarder.firstName) &&
				Objects.equals(lastName, forwarder.lastName) &&
				Objects.equals(email, forwarder.email) &&
				Objects.equals(phoneNumber, forwarder.phoneNumber) &&
				Objects.equals(hireDate, forwarder.hireDate) &&
				Objects.equals(salary, forwarder.salary) &&
				branch == forwarder.branch &&
				Objects.equals(orders, forwarder.orders);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, email, phoneNumber, hireDate, salary, branch, orders);
	}

	@Override
	public String toString() {
		return "Forwarder{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", hireDate=" + hireDate +
				", salary=" + salary +
				", branch=" + branch +
				", orders=" + orders +
				'}';
	}
}
