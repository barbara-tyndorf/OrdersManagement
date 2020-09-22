package com.pl.OrdersManagement.forwarder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.List;

import com.pl.OrdersManagement.order.Order;

@Entity
public class Forwarder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z\\s]*$")
	String fullName;

	@OneToMany
	List<Order> orders;

	public Forwarder() {
	}

	public Forwarder(long id, String fullName,
			List<Order> orders) {
		this.id = id;
		this.fullName = fullName;
		this.orders = orders;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
