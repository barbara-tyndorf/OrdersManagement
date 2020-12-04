package com.pl.OrdersManagement.order;

import com.pl.OrdersManagement.address.Address;
import com.pl.OrdersManagement.address.AddressRepository;
import com.pl.OrdersManagement.address.AddressService;
import com.pl.OrdersManagement.address.errors.NoAddressFoundException;
import com.pl.OrdersManagement.contractor.Contractor;
import com.pl.OrdersManagement.contractor.ContractorRepository;
import com.pl.OrdersManagement.contractor.errors.NoContractorFoundException;
import com.pl.OrdersManagement.enumeration.Currency;
import com.pl.OrdersManagement.forwarder.Forwarder;
import com.pl.OrdersManagement.forwarder.ForwarderRepository;
import com.pl.OrdersManagement.forwarder.ForwarderService;
import com.pl.OrdersManagement.forwarder.errors.NoForwarderFoundException;
import com.pl.OrdersManagement.order.errors.NoOrdersFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	private final ContractorRepository contractorRepository;

	private final AddressRepository addressRepository;

	private final AddressService addressService;

	private final ForwarderRepository forwarderRepository;

	private final ForwarderService forwarderService;

	@Autowired
	public OrderService(OrderRepository orderRepository, ContractorRepository contractorRepository,
			AddressRepository addressRepository, AddressService addressService,
			ForwarderRepository forwarderRepository,
			ForwarderService forwarderService) {
		this.orderRepository = orderRepository;
		this.contractorRepository = contractorRepository;
		this.addressRepository = addressRepository;
		this.addressService = addressService;
		this.forwarderRepository = forwarderRepository;
		this.forwarderService = forwarderService;
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
					throw new NoOrdersFoundException();
				});
	}

	public String remove(String id) {
		Order order = findById(id);
		orderRepository.delete(order);
		return "Order removed successfully!";
	}

	public Order updateOrder(String id, Map<String, String> params) {
		Order order = findById(id);

		if (params.containsKey("customer")) {
			String customerName = params.get("customer");
			Contractor customer = contractorRepository.findByName(customerName);
			order.setCustomer(customer);
		}
		if (params.containsKey("carrierId")) {
			String carrierId = params.get("carrierId");
			Contractor carrier = contractorRepository.findById(carrierId)
					.orElseThrow(() -> {
						throw new NoContractorFoundException();
					});
			order.setCustomer(carrier);
		}
		if (params.containsKey("loadingPlaceId")) {
			Long loadingPlaceId = Long.parseLong(params.get("loadingPlaceId"));
			Address loadingPlace = addressRepository.findById(loadingPlaceId)
					.orElseThrow(() -> {
						throw new NoAddressFoundException();
					});
			order.setLoadingPlace(loadingPlace);
		}

		if (params.containsKey("unloadingPlaceId")) {
			Long unloadingPlaceId = Long.parseLong(params.get("unloadingPlaceId"));
			Address unloadingPlace = addressRepository.findById(unloadingPlaceId)
					.orElseThrow(() -> {
						throw new NoAddressFoundException();
					});
			order.setLoadingPlace(unloadingPlace);
		}
		if (params.containsKey("customerPrice")) {
			double price = Double.parseDouble(params.get("customerPrice"));
			order.setCustomerPrice(BigDecimal.valueOf(price));
		}

		if (params.containsKey("customerCurrency")) {
			order.setCustomerCurrency(Currency.valueOf(params.get("customerCurrency")));
		}

		if (params.containsKey("carrierPrice")) {
			order.setCarrierPrice(BigDecimal.valueOf(Double.parseDouble(params.get("carrierPrice"))));
		}

		if (params.containsKey("carrierCurrency")) {
			order.setCarrierCurrency(Currency.valueOf(params.get("carrierCurrency")));
		}

		if (params.containsKey("forwarderId")) {
			String forwarderId = params.get("forwarderId");
			Forwarder forwarder = forwarderService.findById(forwarderId);
			order.setForwarder(forwarder);
		}

		return orderRepository.save(order);
	}

	public List<Order> findBy(Map<String, String> params) {
		List<Order> foundOrders = new ArrayList<>();

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
			Long addressId = Long.parseLong(params.get("loading_place"));
			Address address = addressRepository.findById(addressId)
					.orElseThrow(() -> {
						throw new NoAddressFoundException();
					});
			foundOrders.addAll(orderRepository.findByLoadingPlace(address));
		}
		if (params.containsKey("unloading_place")) {
			Long addressId = Long.parseLong(params.get("unloading_place"));
			Address address = addressRepository.findById(addressId)
					.orElseThrow(() -> {
						throw new NoAddressFoundException();
					});
			foundOrders.addAll(orderRepository.findByLoadingPlace(address));
		}
		if (params.containsKey("forwarderId")) {
			String id = params.get("forwarderId");
			Forwarder forwarder = forwarderRepository.findById(id)
					.orElseThrow(() -> {
						throw new NoForwarderFoundException();
					});
			foundOrders.addAll(orderRepository.findAllByForwarder(forwarder));
		}
		return foundOrders;
	}
}
