package com.pl.OrdersManagement.contractor.errors;

public class ContractorExistException extends RuntimeException {

	public ContractorExistException() {
		super("Contractor already exist!");
	}
}
