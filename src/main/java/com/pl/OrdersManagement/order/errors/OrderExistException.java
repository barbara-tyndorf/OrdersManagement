package com.pl.OrdersManagement.order.errors;

public class OrderExistException extends RuntimeException {

	public OrderExistException() {
		super ("Order already exist!");
	}
}
