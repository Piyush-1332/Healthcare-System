package com.cg.hmsintegrated.exception;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     Appointment not found in the centre 

*******************************************************************************************************************************/

@SuppressWarnings("serial")
public class AppointmentNotFoundException extends Exception{
	public AppointmentNotFoundException(String errormessgae){
		super(errormessgae);
	}
}
