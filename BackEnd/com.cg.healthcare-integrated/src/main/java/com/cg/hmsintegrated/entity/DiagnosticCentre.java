package com.cg.hmsintegrated.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import org.hibernate.annotations.DynamicUpdate;



/************************************************************************************
 *          @author          Jaspreet Singh Ahuja
 *          Description      It is a entity class that provides the attributes for 
 *                           diagnostic centre made by admin .
 *          Version             1.0
 *          Created Date    20-APR-2020
 ************************************************************************************/


@Entity
@Table(name= "DIAGNOSTIC_CENTRE")
@DynamicUpdate
public class DiagnosticCentre{
	

	/*************Centre Id ****************/
	@Id
	@Column(name= "CENTRE_ID",nullable = false)
	@NotNull(message="ID cannot be empty")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long centreId;
    
	/*************Centre Name ****************/
    @Column(name= "CENTRE_NAME",length=25,nullable = false)
    @NotNull(message="Name cannot be empty")
   // @Pattern(regexp = "^[a-zA-z]+([\\s][a-zA-Z]+)*$",message = "centre name invalid")
	private String centreName;
    
    /*********Centre Contact Number **********/
    //@Pattern(regexp="[6-9]{1}\\d{9}",message="Phone Number InValid")
    @Column(name= "CENTRE_CONTACT_NUMBER",length=11,nullable = false)
    @NotNull(message="Number cannot be empty")
   	private long centreContactNumber;
    
    /*************Centre Address **************/
    @Column(name= "CENTRE_ADDRESS",length=50,nullable = false)
   // @Pattern(regexp = "^[a-zA-z]+([\\s][a-zA-Z]+)*$",message = "address invalid")
    @NotNull(message="Address cannot be empty")
   	private String centreAddress;



    /**************Getters and Setters***********/
    public long getCentreId() {
		return centreId;
	}


	public void setCentreId(long centreId) {
		this.centreId = centreId;
	}


	public String getCentreName() {
		return centreName;
	}


	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}


	public long getCentreContactNumber() {
		return centreContactNumber;
	}


	public void setCentreContactNumber(long centreContactNumber) {
		this.centreContactNumber = centreContactNumber;
	}


	public String getCentreAddress() {
		return centreAddress;
	}


	public void setCentreAddress(String centreAddress) {
		this.centreAddress = centreAddress;
	}
	
	/**************Default Constructor**************/
	public DiagnosticCentre() {}
	
	
	/************Parameterized Constructor***********/
	public DiagnosticCentre( String centreName, long centreContactNumber, String centreAddress) {
			super();
			//this.centreId = centreId;
			this.centreName = centreName;
			this.centreContactNumber = centreContactNumber;
			this.centreAddress = centreAddress;
		}


		@Override
	public String toString() {
			return "Centre [centreId=" + centreId + ", centreName=" + centreName + ", centreContactNumber="
					+ centreContactNumber + ", centreAddress=" + centreAddress + "]";
		}
		

	
}