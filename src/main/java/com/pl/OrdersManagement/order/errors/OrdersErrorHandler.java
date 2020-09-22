package com.pl.OrdersManagement.order.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrdersErrorHandler {

	@ExceptionHandler(NoOrdersFoundException.class)
	public ResponseEntity<Object> noLocationsFoundException(NoOrdersFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(OrderExistException.class)
	public ResponseEntity<Object> locationExistException(OrderExistException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
