package com.pl.OrdersManagement.order;

import com.pl.OrdersManagement.address.Address;
import com.pl.OrdersManagement.address.AddressRepository;
import com.pl.OrdersManagement.contractor.Contractor;
import com.pl.OrdersManagement.contractor.ContractorRepository;
import com.pl.OrdersManagement.forwarder.Forwarder;
import com.pl.OrdersManagement.forwarder.ForwarderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	private final ContractorRepository contractorRepository;

	private final AddressRepository addressRepository;

	private final ForwarderRepository forwarderRepository;

	@Autowired
	public OrderService(OrderRepository orderRepository, ContractorRepository contractorRepository,
			AddressRepository addressRepository, ForwarderRepository forwarderRepository) {
		this.orderRepository = orderRepository;
		this.contractorRepository = contractorRepository;
		this.addressRepository = addressRepository;
		this.forwarderRepository = forwarderRepository;
	}

	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	public Order add(Order order) {
		return orderRepository.save(order);
	}

	public Order findById(String id) {
		return orderRepository.findById(id)
				.orElseThrow(() -> {
					throw new NoSuchElementException();
				});
	}

	public Order remove(String id) {
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> {
					throw new NoSuchElementException();
				});
		orderRepository.delete(order);
		return order;
	}

	public Order updateOrder(String id, Map<String, String> params) {
		Order order = orderRepository.findById(id).orElseThrow(() -> {
			throw new NoSuchElementException();
		});

		if (params.containsKey("customer")) {
			String name = params.get("customer");
			Contractor customer = contractorRepository.findByName(name);
			order.setCustomer(customer);
		}
		if (params.containsKey("carrier")) {
			String name = params.get("carrier");
			Contractor carrier = contractorRepository.findByName(name);
			order.setCustomer(carrier);
		}
		if (params.containsKey("loading_place")) {
			//TODO pattern for loading_place (array with loading params) and checking every field
			// if is not empty or equal to already exist and change field if not
//			addressService.update(params.get("loading_place"));
		}
		if (params.containsKey("unloading_place")) {
			//TODO as above
//			addressService.update(params.get("unloading_place"));
		}
		if (params.containsKey("customerPrice")) {
			order.setCustomerPrice(BigDecimal.valueOf(Double.parseDouble(params.get("customerPrice"))));
		}

		if (params.containsKey("customerCurrency")) {
			order.setCustomerCurrency(Currency.getInstance(params.get("customerCurrency")));
		}

		if (params.containsKey("carrierPrice")) {
			order.setCarrierPrice(BigDecimal.valueOf(Double.parseDouble(params.get("carrierPrice"))));
		}

		if (params.containsKey("carrierCurrency")) {
			order.setCarrierCurrency(Currency.getInstance(params.get("carrierCurrency")));
		}
		if (params.containsKey("forwarder")) {
//			forwarderService.update();
		}

		return orderRepository.save(order);
	}

	public List<Order> findBy(Map<String, String> params) {
		List<Order> foundOrders = new ArrayList<>();

		if (params.containsKey("id")) {
			String id = params.get("id");
			orderRepository.findById(id)
					.ifPresent(foundOrders::add);
		}
		if (params.containsKey("customer")) {
			String name = params.get("customer");
			Contractor customer = contractorRepository.findByName(name);
			foundOrders.addAll(orderRepository.findByCustomer(customer));
		}
		if (params.containsKey("carrier")) {
			String name = params.get("carrier");
			Contractor carrier = contractorRepository.findByName(name);
			foundOrders.addAll(orderRepository.findByCustomer(carrier));
		}
		if (params.containsKey("loading_place")) {
			String city = params.get("loading_place");
			List<Address> addresses = addressRepository.findAllByCity(city);
			for (Address a : addresses) {
				foundOrders.addAll(orderRepository.findByLoadingPlace(a));
			}
		}
		if (params.containsKey("unloading_place")) {
			String city = params.get("unloading_place");
			List<Address> addresses = addressRepository.findAllByCity(city);
			for (Address a : addresses) {
				foundOrders.addAll(orderRepository.findByLoadingPlace(a));
			}
		}
		if (params.containsKey("customer_price")) {
			BigDecimal price = BigDecimal.valueOf(Double.parseDouble(params.get("customer_price")));
			foundOrders.addAll(orderRepository.findByCustomerPrice(price));
		}
		if (params.containsKey("customer_currency")) {
			Currency currency = Currency.getInstance(params.get("customer_currency"));
			foundOrders.addAll(orderRepository.findByCustomerCurrency(currency));
		}
		if (params.containsKey("carrier_price")) {
			BigDecimal price = BigDecimal.valueOf(Double.parseDouble(params.get("carrier_price")));
			foundOrders.addAll(orderRepository.findByCarrierPrice(price));
		}
		if (params.containsKey("carrier_currency")) {
			Currency currency = Currency.getInstance(params.get("customer_currency"));
			foundOrders.addAll(orderRepository.findByCarrierCurrency(currency));
		}
		if (params.containsKey("forwarder")) {
			String name = params.get("forwarder");
			Forwarder forwarder = forwarderRepository.findByFullName(name);
			foundOrders.addAll(orderRepository.findAllByForwarder(forwarder));
		}
		return foundOrders;
	}
}
