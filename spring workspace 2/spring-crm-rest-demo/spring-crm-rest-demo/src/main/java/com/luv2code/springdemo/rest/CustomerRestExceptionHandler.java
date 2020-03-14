package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> 
		handleNotFoundException(CustomerNotFoundException ex) {
		
		CustomerErrorResponse response = new CustomerErrorResponse();
		
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(ex.getMessage());
		response.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
	}
	
	// catch all errors
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> 
		handleGenericException(Exception ex) {
		
		CustomerErrorResponse response = new CustomerErrorResponse();
		
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(ex.getMessage());
		response.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}
}
