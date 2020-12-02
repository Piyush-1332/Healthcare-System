package com.cg.hmsintegrated.model;


import com.cg.hmsintegrated.entity.StatusEntity;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     Data Transfer Object

*******************************************************************************************************************************/


public class AppointmentModel {
	private int appointmentId;
	private String centreId;
	private String userId;
	private String testId;
	private String dateTime;
	private StatusEntity status;
	
	
	public AppointmentModel(int appointmentId, String centreId, String userId, String testId,
			String dateTime, StatusEntity status) {
		super();
		this.appointmentId = appointmentId;
		this.centreId = centreId;
		this.userId = userId;
		this.dateTime = dateTime;
		this.status = status;
		this.testId = testId;
	}

	public AppointmentModel() {
		// 
		super();
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int string) {
		this.appointmentId = string;
	}

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}
}


