package com.cg.hmsintegrated.service;

import java.util.List;

import com.cg.hmsintegrated.entity.TestEntity;




/*******************************************************************************************************************************
-Author                   :     Nittu Naveen Kumar
-Created/Modified Date    :     25-11-2020
-Description              :     TestInterface layer at Service

*******************************************************************************************************************************/


public interface TestServiceI {
	public void  addTest(TestEntity test);
	public void  removeTest(Long testId);
	public TestEntity FindById(Long testId);
	
	public List<TestEntity>viewAll();

}
