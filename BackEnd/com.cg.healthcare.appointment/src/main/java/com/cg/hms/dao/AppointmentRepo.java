package com.cg.hms.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cg.hms.entity.AppointmentEntity;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     Jpa Repository class 

*******************************************************************************************************************************/

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentEntity,Integer>{
	@Query("select a from AppointmentEntity a where a.testId=:tid and a.dateTime=:dt")
	public AppointmentEntity getAppointmentBytestIdAndDateTime(@Param("dt") String dateTime, @Param("tid") String testId);
	
	@Query("FROM AppointmentEntity where centreId =:cid")
	public List<AppointmentEntity> findAll(@Param("cid") String centreId);
	
	@Query("FROM AppointmentEntity where userId =:uid")
	public List<AppointmentEntity> findAllByUserId(@Param("uid") String userId);
	
	



	
}
