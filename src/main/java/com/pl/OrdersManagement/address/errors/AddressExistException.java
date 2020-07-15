package com.pl.OrdersManagement.address.errors;

public class AddressExistException extends RuntimeException {

    public AddressExistException() {
        super("Address already exist!");
    }
}
