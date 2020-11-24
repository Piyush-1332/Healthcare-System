package com.cg.hms.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entity.AppointmentEntity;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :      

*******************************************************************************************************************************/

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentEntity,BigInteger>{
	
}
