package com.cg.hms.exception;

@SuppressWarnings("serial")
public class AppointmentAlreadyDisapprovedException extends Exception{

	public AppointmentAlreadyDisapprovedException(String errormessage) {
		super(errormessage);
	}

}
