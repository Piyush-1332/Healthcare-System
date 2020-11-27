package com.cg.hms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     All Exception Handler Class 

*******************************************************************************************************************************/



@RestControllerAdvice
public class AppointmentExceptionHandler {
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<String> handleAppointmentNotFoundException(AppointmentNotFoundException exp) 
	{
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AppointmentAlreadyApprovedException.class)
	public ResponseEntity<String> handleAppointmentAlreadyApprovedException(AppointmentAlreadyApprovedException exp) 
	{
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(AppointmentAlreadyDisapprovedException.class)
	public ResponseEntity<String> handleAppointmentAlreadyDisapprovedException(AppointmentAlreadyDisapprovedException exp) 
	{
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(SlotNotAvailableException.class)
	public ResponseEntity<String> handleSlotNotAvailableException(SlotNotAvailableException exp)
	{
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleInvalidData(Exception exp) 
	{
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	

	
}
