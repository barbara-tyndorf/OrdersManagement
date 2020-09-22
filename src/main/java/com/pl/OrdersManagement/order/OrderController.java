package com.pl.OrdersManagement.order;

import javax.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public Order add(@Valid @RequestBody Order order) {
		return orderService.add(order);
	}

	@GetMapping
	public List<Order> getAll() {
		return orderService.getAll();
	}

	@GetMapping("/{id}")
	public Order getOrderById(@Valid @PathVariable String id) {
		return orderService.findById(id);
	}

	@GetMapping("/find")
	public List<Order> getOrdersBy(@RequestParam(required = false) Map<String, String> params) {
		return orderService.findBy(params);
	}

	@PutMapping
	public Order update(@RequestParam String id, Map<String, String> params) {
		return orderService.updateOrder(id, params);
	}

	@DeleteMapping
	public String delete(@RequestParam String id) {
		return orderService.remove(id);
	}

}
