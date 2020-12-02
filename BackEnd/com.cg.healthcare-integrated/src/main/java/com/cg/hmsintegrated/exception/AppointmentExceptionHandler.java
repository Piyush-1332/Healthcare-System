package com.cg.hmsintegrated.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



/*******************************************************************************************************************************
 * -Author : Piyush Srivastav -Created/Modified Date : 26-11-2020 -Description :
 * All Exception Handler Class
 * 
 *******************************************************************************************************************************/

@RestControllerAdvice
public class AppointmentExceptionHandler {
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<String> handleAppointmentNotFoundException(AppointmentNotFoundException exp) {
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AppointmentAlreadyApprovedException.class)
	public ResponseEntity<String> handleAppointmentAlreadyApprovedException(AppointmentAlreadyApprovedException exp) {
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.ALREADY_REPORTED);
	}

	@ExceptionHandler(AppointmentAlreadyDisapprovedException.class)
	public ResponseEntity<String> handleAppointmentAlreadyDisapprovedException(
			AppointmentAlreadyDisapprovedException exp) {
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.ALREADY_REPORTED);
	}

	@ExceptionHandler(SlotNotAvailableException.class)
	public ResponseEntity<String> handleSlotNotAvailableException(SlotNotAvailableException exp) {
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(value = CentreException.class)
	public ResponseEntity<String> handleProductException(CentreException exception) {
//		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Failed", exception.getErrorsMap());
//		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleInvalidData(Exception exp) {
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
