package com.cg.hms.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.sun.istack.NotNull;

/*******************************************************************************************************************************
 * -Author : Piyush Srivastav -Created/Modified Date : 26-11-2020 -Description :
 * Entity Class
 * 
 *******************************************************************************************************************************/

@Entity
public class AppointmentEntity {
	@Id
	@Column(length=40)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int appointmentId;
	
	@Column(length=40)
	@NotNull
	private String centreId;

	@NotNull
	@Column(length=40)
	private String userId;

	@NotNull
	@Column(length=40)
	private String testId;

	@NotNull
	@Column(length=40)
	private String dateTime;

	private StatusEntity status;

	public AppointmentEntity(int appointmentId, String centreId, String userId, String testId,
			String dateTime, StatusEntity status) {
		super();
		this.appointmentId = appointmentId;
		this.centreId = centreId;
		this.userId = userId;
		this.testId = testId;
		this.dateTime = dateTime;
		this.status = status;
	}

	public AppointmentEntity() {
		super();
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
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
