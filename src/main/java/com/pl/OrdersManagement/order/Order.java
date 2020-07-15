package com.pl.OrdersManagement.order;

import com.pl.OrdersManagement.address.Address;
import com.pl.OrdersManagement.contractor.Contractor;
import com.pl.OrdersManagement.forwarder.Forwarder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Entity
public class Order {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@NotNull
	@ManyToOne
	private Contractor customer;

	@NotNull
	@ManyToOne
	private Contractor carrier;

	@NotNull
	@OneToMany
	private List<Address> loadingPlace;

	@NotNull
	@OneToMany
	private List<Address> unloadingPlace;

	@Min(0)
	private BigDecimal customerPrice;

	@NotNull
	private Currency customerCurrency;

	@Min(0)
	private BigDecimal carrierPrice;

	@NotNull
	private Currency carrierCurrency;

	@NotNull
    @ManyToOne
	private Forwarder forwarder;

	public Order() {
	}

	public Order(String id, Contractor customer, Contractor carrier, List<Address> loadingPlace,
			List<Address> unloadingPlace, BigDecimal customerPrice, Currency customerCurrency,
            BigDecimal carrierPrice, Currency carrierCurrency, Forwarder forwarder) {
		this.id = id;
		this.customer = customer;
		this.carrier = carrier;
		this.loadingPlace = loadingPlace;
		this.unloadingPlace = unloadingPlace;
		this.customerPrice = customerPrice;
		this.customerCurrency = customerCurrency;
		this.carrierPrice = carrierPrice;
		this.carrierCurrency = carrierCurrency;
		this.forwarder = forwarder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Contractor getCustomer() {
		return customer;
	}

	public void setCustomer(Contractor customer) {
		this.customer = customer;
	}

	public Contractor getCarrier() {
		return carrier;
	}

	public void setCarrier(Contractor carrier) {
		this.carrier = carrier;
	}

	public List<Address> getLoadingPlace() {
		return loadingPlace;
	}

	public void setLoadingPlace(List<Address> loadingPlace) {
		this.loadingPlace = loadingPlace;
	}

	public List<Address> getUnloadingPlace() {
		return unloadingPlace;
	}

	public void setUnloadingPlace(List<Address> unloadingPlace) {
		this.unloadingPlace = unloadingPlace;
	}

	public BigDecimal getCustomerPrice() {
		return customerPrice;
	}

	public void setCustomerPrice(BigDecimal customerPrice) {
		this.customerPrice = customerPrice;
	}

	public Currency getCustomerCurrency() {
		return customerCurrency;
	}

	public void setCustomerCurrency(Currency customerCurrency) {
		this.customerCurrency = customerCurrency;
	}

	public BigDecimal getCarrierPrice() {
		return carrierPrice;
	}

	public void setCarrierPrice(BigDecimal carrierPrice) {
		this.carrierPrice = carrierPrice;
	}

	public Currency getCarrierCurrency() {
		return carrierCurrency;
	}

	public void setCarrierCurrency(Currency carrierCurrency) {
		this.carrierCurrency = carrierCurrency;
	}

    public Forwarder getForwarder() {
        return forwarder;
    }

    public void setForwarder(Forwarder forwarder) {
        this.forwarder = forwarder;
    }
}
