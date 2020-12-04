package com.pl.OrdersManagement.order.errors;

public class NoOrdersFoundException extends RuntimeException {

	public NoOrdersFoundException() {
		super ("Orders not found!");
	}

}
