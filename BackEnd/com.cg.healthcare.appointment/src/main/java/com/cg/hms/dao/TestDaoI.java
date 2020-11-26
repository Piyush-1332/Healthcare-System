package com.cg.hms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.hms.entity.TestEntity;


/*******************************************************************************************************************************
-Author                   :     Nittu Naveen Kumar
-Created/Modified Date    :     25-11-2020
-Description              :      

*******************************************************************************************************************************/






@Repository
public interface TestDaoI {
	
	public void addTest(TestEntity test);
	public void removeTest(Long testId);
	public TestEntity FindById(Long testId);
	public List<TestEntity>viewAllTest();

}
