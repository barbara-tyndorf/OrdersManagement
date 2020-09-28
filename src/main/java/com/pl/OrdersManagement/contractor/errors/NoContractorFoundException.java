package com.pl.OrdersManagement.contractor.errors;

public class NoContractorFoundException extends RuntimeException {

	public NoContractorFoundException() {
		super ("Contractor not found!");
	}
}
