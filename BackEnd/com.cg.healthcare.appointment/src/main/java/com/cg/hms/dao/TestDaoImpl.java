package com.cg.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.hms.entity.TestEntity;

/*******************************************************************************************************************************
-Author                   :     Nittu Naveen Kumar
-Created/Modified Date    :     25-11-2020
-Description              :     Implementation of Interface at DAO layer 

*******************************************************************************************************************************/






@Repository
@Transactional
public class TestDaoImpl implements TestDaoI{
	@PersistenceContext
	EntityManager entitymanager;

	@Override
	public void addTest(TestEntity test) {
		
		entitymanager.persist(test);
	
	}

	@Override
	public void removeTest(Long TestId) {
		TestEntity test = entitymanager.find(TestEntity.class,TestId);
		entitymanager.remove(test);
	}

	@Override
	public List<TestEntity> viewAllTest() {
		Query q = entitymanager.createQuery("from TestEntity",TestEntity.class);
		return q.getResultList() ;
	}

	@Override
	public TestEntity FindById(Long testId) {
		TestEntity test = entitymanager.find(TestEntity.class, testId);
		return test;
	}

}
