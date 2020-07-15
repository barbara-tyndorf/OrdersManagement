package com.pl.OrdersManagement.order;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

import com.pl.OrdersManagement.address.Address;
import com.pl.OrdersManagement.contractor.Contractor;
import com.pl.OrdersManagement.forwarder.Forwarder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {

	List<Order> findByCustomer(Contractor customer);
	List<Order> findByLoadingPlace (Address address);
	List<Order> findByCustomerPrice (BigDecimal price);
	List<Order> findByCustomerCurrency (Currency currency);
	List<Order> findByCarrierPrice (BigDecimal price);
	List<Order> findByCarrierCurrency (Currency currency);
	List<Order> findAllByForwarder(Forwarder forwarder);


}
