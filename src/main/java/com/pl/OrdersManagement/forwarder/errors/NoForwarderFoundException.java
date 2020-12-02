package com.pl.OrdersManagement.forwarder.errors;

public class NoForwarderFoundException extends RuntimeException {

	public NoForwarderFoundException() {
		super("No forwarder found!");
	}

}
