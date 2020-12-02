package com.pl.OrdersManagement.address.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressErrorHandler {

    @ExceptionHandler(NoAddressFoundException.class)
    public ResponseEntity<Object> NoAddressFoundException(NoAddressFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AddressExistException.class)
    public ResponseEntity<Object> AddressExistException(AddressExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
