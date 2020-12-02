package com.cg.hmsintegrated.exception;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     AppointmentAlreadyApprovedException Class 

*******************************************************************************************************************************/


@SuppressWarnings("serial")
public class AppointmentAlreadyApprovedException extends Exception{

	public AppointmentAlreadyApprovedException(String errormessage) {
		super(errormessage);
	}

}
