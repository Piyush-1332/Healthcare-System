package com.cg.hmsintegrated.exception;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     Exception if Slot is not available 

*******************************************************************************************************************************/


@SuppressWarnings("serial")
public class SlotNotAvailableException extends Exception{

	public SlotNotAvailableException(String errorMessage) {
		super(errorMessage);
	}
	
}
