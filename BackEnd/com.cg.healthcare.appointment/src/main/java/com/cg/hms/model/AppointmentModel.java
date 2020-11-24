package com.cg.hms.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.cg.hms.entity.StatusEntity;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     Data Transfer Object

*******************************************************************************************************************************/


public class AppointmentModel {
	private BigInteger appointmentId;
	private String centreId;
	private String userId;
	private String testId;
	private LocalDateTime dateTime;
	private StatusEntity status;
	
	
	public AppointmentModel(BigInteger appointmentId, String centreId, String userId, String testId,
			LocalDateTime dateTime, StatusEntity status) {
		super();
		this.appointmentId = appointmentId;
		this.centreId = centreId;
		this.userId = userId;
		this.dateTime = dateTime;
		this.status = status;
		this.testId = testId;
	}

	public BigInteger getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(BigInteger appointmentId) {
		this.appointmentId = appointmentId;
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

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}
}


