package com.cg.hms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.context.junit4.SpringRunner;

import com.cg.hms.dao.AppointmentRepo;
import com.cg.hms.entity.AppointmentEntity;
import com.cg.hms.entity.StatusEntity;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     Test Class for Repository Testing 

*******************************************************************************************************************************/

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentRepoTest {
	
	@Autowired
	private TestEntityManager entityManger;
	
	@Autowired
	private AppointmentRepo appointmentRepo;
	
	@Test
	public void testSaveAppointment() {
		AppointmentEntity appointmentEntity = getAppointmentEntity();
		AppointmentEntity savedInDb = entityManger.persist(appointmentEntity);
		
		Optional<AppointmentEntity> getFromDb = appointmentRepo.findById(savedInDb.getAppointmentId());
		
		assertThat(getFromDb).isEqualTo(savedInDb);
		 
		
	}
	
	private AppointmentEntity getAppointmentEntity() {
		AppointmentEntity appointmentEntity= new AppointmentEntity();
		appointmentEntity.setAppointmentId(2);
		appointmentEntity.setUserId("01");
		appointmentEntity.setCentreId("102");
		appointmentEntity.setDateTime("2020-11-29 14:30");
		appointmentEntity.setTestId("t102");
		appointmentEntity.setStatus(StatusEntity.pending);
		
		return appointmentEntity;
		
	}
}
