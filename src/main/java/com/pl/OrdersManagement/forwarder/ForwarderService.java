package com.pl.OrdersManagement.forwarder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pl.OrdersManagement.enumeration.Branch;
import com.pl.OrdersManagement.forwarder.errors.ForwarderExistException;
import com.pl.OrdersManagement.forwarder.errors.NoForwarderFoundException;
import com.pl.OrdersManagement.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForwarderService {

	private final ForwarderRepository forwarderRepository;
	private final OrderService orderService;

	@Autowired
	public ForwarderService(ForwarderRepository forwarderRepository, OrderService orderService) {
		this.forwarderRepository = forwarderRepository;
		this.orderService = orderService;
	}

	public List<Forwarder> getAll() {
		return forwarderRepository.findAll();
	}

	public Forwarder add(Forwarder forwarder) {
		forwarderRepository.findAll().stream()
				.filter((f) -> f.getEmail().equals(forwarder.getEmail()))
				.findAny()
				.ifPresent((f) -> {
					throw new ForwarderExistException();
				});
		return forwarderRepository.save(forwarder);
	}

	public Forwarder findById(String id) {
		return forwarderRepository.findById(id)
				.orElseThrow(() -> {
					throw new NoForwarderFoundException();
				});
	}

	public List<Forwarder> findBy(Map<String, String> params) {
		List<Forwarder> foundForwarders = new ArrayList<>();
		if (params.containsKey("branch")) {
			Branch branch = Branch.valueOf(params.get("branch"));
			foundForwarders.addAll(forwarderRepository.findByBranch(branch));
		}
		if (params.containsKey("lastName")) {
			String lastName = params.get("lastName");
			foundForwarders.addAll(forwarderRepository.findByLastName(lastName));
		}
		if (params.containsKey("firstName") && params.containsKey("lastName")) {
			String firstName = params.get("firstName");
			String lastName = params.get("lastName");
			foundForwarders.addAll(forwarderRepository.findByFirstNameAndLastName(firstName, lastName));
		}
		return foundForwarders;
	}

	public String remove(String id) {
		Forwarder forwarder = findById(id);
		forwarderRepository.delete(forwarder);
		return "Forwarder removed successfully!";
	}

	public Forwarder updateForwarder(String id, Map<String, String> params) {
		Forwarder forwarder = findById(id);

		//TODO

		return forwarder;
	}

	public BigDecimal getProfit(String id) {
		Forwarder forwarder = findById(id);
		List<Long> ordersIds = forwarder.getOrders().stream()
				.map((o) -> o.getId())
				.collect(Collectors.toList());

		BigDecimal profit = BigDecimal.ZERO;
		for (int i = 0; i < ordersIds.size(); i++) {
			BigDecimal orderProfit = orderService.getProfit(ordersIds.get(i));
			profit = profit.add(orderProfit);
		}
		return profit;
	}

}
