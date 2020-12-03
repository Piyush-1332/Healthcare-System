package com.cg.hmsintegrated.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hmsintegrated.entity.TestEntity;
import com.cg.hmsintegrated.exception.TestDetailsNotFoundException;
import com.cg.hmsintegrated.exception.TestInvalidException;
import com.cg.hmsintegrated.service.TestServiceI;




/*******************************************************************************************************************************
-Author                   :     Nittu Naveen Kumar
-Created/Modified Date    :     25-11-2020
-Description              :     Test Api Rest Controller  

*******************************************************************************************************************************/


@CrossOrigin(origins= "*")
@Validated
@RestController
public class TestController {
	
	@Autowired
	TestServiceI testservice;
	TestEntity testentity;
	
	// here  persisting data to database 
	
	@PostMapping(value="/add",consumes={"application/json"})
	
	public ResponseEntity<Object> addTest(@RequestBody TestEntity test) throws TestInvalidException
	{
		
		
		testservice.addTest(test);
		  return new ResponseEntity<>("Test added ",HttpStatus.OK);
			
		
		
			
		
			
		
			
		  
		
	}
	
	//here retrieving the  data form database to view 
	
	@GetMapping(value="/view")
	public  ResponseEntity<Object> viewAllTest() throws TestDetailsNotFoundException
	{
		List<TestEntity>testView = testservice.viewAll();
		if(testView!=null)
		{
			return new ResponseEntity<>(testservice.viewAll(),HttpStatus.OK);
		}
		else
		{
			throw new TestDetailsNotFoundException("you haven't Added any Test yet");
		}
		 
		
	}
	
	
	//here deleting the data from the database
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Object> removeTest(@PathVariable Long id) throws TestDetailsNotFoundException
	{
		TestEntity test = testservice.FindById(id);
		if(test!=null)
		{
		
			testservice.removeTest(id);
			
			return new ResponseEntity<>("Test removed ",HttpStatus.OK);
		}
		else
		{
			
			throw new TestDetailsNotFoundException("testId didn't exist ");
			
		}
		
		
		
	}
	

}
