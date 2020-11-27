package com.cg.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;


/*******************************************************************************************************************************
-Author                   :     Nittu Naveen Kumar
-Created/Modified Date    :     25-11-2020
-Description              :      

*******************************************************************************************************************************/







@Entity
@Table(name="TestDetailsData")
public class TestEntity {
	TestEntity()
	{
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "testId")@NotNull
	private Long testId;
	
	@Column(name = "testName")@NotNull 
	@Size(min = 1 , max = 15)
    private String testName;
	

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

		

	public TestEntity(Long testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}


}
