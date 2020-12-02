package com.pl.OrdersManagement.forwarder.errors;

public class ForwarderExistException extends RuntimeException {

	public ForwarderExistException() {
		super("Forwarder already exist!");
	}

}
