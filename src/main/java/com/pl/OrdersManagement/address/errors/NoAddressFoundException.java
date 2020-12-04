package com.pl.OrdersManagement.address.errors;

public class NoAddressFoundException extends RuntimeException {

	public NoAddressFoundException() {
		super("Address not found!");
	}
}
