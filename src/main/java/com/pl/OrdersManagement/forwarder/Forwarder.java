package com.pl.OrdersManagement.forwarder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import com.pl.OrdersManagement.order.Order;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Forwarder {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z\\s]*$")
	String fullName;

	@OneToMany
	List<Order> orders;

	public Forwarder() {
	}

	public Forwarder(String id, String fullName,
			List<Order> orders) {
		this.id = id;
		this.fullName = fullName;
		this.orders = orders;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
