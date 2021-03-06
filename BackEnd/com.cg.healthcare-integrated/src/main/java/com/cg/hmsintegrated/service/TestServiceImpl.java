package com.cg.hmsintegrated.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hmsintegrated.dao.TestDaoI;
import com.cg.hmsintegrated.entity.TestEntity;



/*******************************************************************************************************************************
-Author                   :     Nittu Naveen Kumar 
-Created/Modified Date    :     25-11-2020
-Description              :     Test Implementation for Interface at Service layer

*******************************************************************************************************************************/


@Service
public class TestServiceImpl implements TestServiceI {
	@Autowired
	TestDaoI testdao;

	@Override
	public void addTest(TestEntity test) {
		testdao.addTest(test);
		
	}

	@Override
	public void removeTest(Long testId) {
	
		testdao.removeTest(testId);
	}
	

	@Override
	public List<TestEntity> viewAll() {
		
		
		return testdao.viewAllTest();
	}
	
	
	

	@Override
	public TestEntity FindById(Long testId) {
	
		return 	testdao.FindById(testId);
	}

	

}
