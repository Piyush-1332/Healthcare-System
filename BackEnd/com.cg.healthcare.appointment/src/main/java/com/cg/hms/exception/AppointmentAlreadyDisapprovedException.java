package com.cg.hms.exception;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     AppointmentAlreadyDisapprovedException Class 

*******************************************************************************************************************************/


@SuppressWarnings("serial")
public class AppointmentAlreadyDisapprovedException extends Exception{

	public AppointmentAlreadyDisapprovedException(String errormessage) {
		super(errormessage);
	}

}
