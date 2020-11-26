package com.cg.hms.exception;

@SuppressWarnings("serial")
public class AppointmentAlreadyApprovedException extends Exception{

	public AppointmentAlreadyApprovedException(String errormessage) {
		super(errormessage);
	}

}
