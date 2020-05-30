package com.pl.OrdersManagement.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order add(Order order) {
        return orderRepository.save(order);
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

        if (params.containsKey("customerPrice")) {
            order.setCustomerPrice(params.get("customerPrice"));
        }

        if (params.containsKey("customerCurrency")) {
            order.setCustomerCurrency(params.get("customerCurrency"));
        }

        if (params.containsKey("carrierPrice")) {
            order.setCarrierPrice(params.get("carrierPrice"));
        }

        if (params.containsKey("carrierCurrency")) {
            order.setCarrierCurrency(params.get("carrierCurrency"));
        }
        return orderRepository.save(order);
    }
}
