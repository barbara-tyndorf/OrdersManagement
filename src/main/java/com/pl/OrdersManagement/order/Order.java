package com.pl.OrdersManagement.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pl.OrdersManagement.address.Address;
import com.pl.OrdersManagement.contractor.Contractor;
import com.pl.OrdersManagement.enumeration.Currency;
import com.pl.OrdersManagement.forwarder.Forwarder;
import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "customer_price", precision = 21, scale = 2)
	private BigDecimal customerPrice;

	@Column(name = "carrier_price", precision = 21, scale = 2)
	private BigDecimal carrierPrice;

	@Enumerated(EnumType.STRING)
	@Column(name = "customer_currency")
	private Currency customerCurrency;

	@Enumerated(EnumType.STRING)
	@Column(name = "carrier_currency")
	private Currency carrierCurrency;

	@ManyToOne
	@JsonIgnoreProperties("orders")
	private Contractor customer;

	@ManyToOne
	@JsonIgnoreProperties("orders")
	private Contractor carrier;

	@ManyToOne
	@JsonIgnoreProperties("orders")
	private Address loadingPlace;

	@ManyToOne
	@JsonIgnoreProperties("orders")
	private Address unloadingPlace;

	@ManyToOne
	@JsonIgnoreProperties("orders")
	private Forwarder forwarder;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Order order = (Order) o;
		return Objects.equals(id, order.id) &&
				Objects.equals(customerPrice, order.customerPrice) &&
				Objects.equals(carrierPrice, order.carrierPrice) &&
				Objects.equals(customerCurrency, order.customerCurrency) &&
				Objects.equals(carrierCurrency, order.carrierCurrency) &&
				Objects.equals(customer, order.customer) &&
				Objects.equals(carrier, order.carrier) &&
				Objects.equals(loadingPlace, order.loadingPlace) &&
				Objects.equals(unloadingPlace, order.unloadingPlace) &&
				Objects.equals(forwarder, order.forwarder);
	}

	@Override
	public int hashCode() {
		return Objects
				.hash(id, customerPrice, carrierPrice, customerCurrency, carrierCurrency, customer, carrier, loadingPlace,
						unloadingPlace, forwarder);
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", customerPrice=" + customerPrice +
				", carrierPrice=" + carrierPrice +
				", customerCurrency=" + customerCurrency +
				", carrierCurrency=" + carrierCurrency +
				", customer=" + customer +
				", carrier=" + carrier +
				", loadingPlace=" + loadingPlace +
				", unloadingPlace=" + unloadingPlace +
				", forwarder=" + forwarder +
				'}';
	}
}
