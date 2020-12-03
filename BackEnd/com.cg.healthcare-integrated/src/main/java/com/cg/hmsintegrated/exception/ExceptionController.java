package com.cg.hmsintegrated.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {

	
	
	@ExceptionHandler(value = TestDetailsNotFoundException.class)
	public ResponseEntity<Object> handleNullException(TestDetailsNotFoundException exception)
	{
	return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value = TestInvalidException.class)
	public ResponseEntity<Object> handleNullException(TestInvalidException exception)
	{
	return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
	
}
