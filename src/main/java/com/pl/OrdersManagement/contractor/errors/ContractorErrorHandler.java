package com.pl.OrdersManagement.contractor.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContractorErrorHandler {

	@ExceptionHandler(NoContractorFoundException.class)
	public ResponseEntity<Object> NoContractorFoundException(NoContractorFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ContractorExistException.class)
	public ResponseEntity<Object> ContractorExistException(ContractorExistException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
