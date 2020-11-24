package com.cg.hms.service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.hms.dao.AppointmentRepo;
import com.cg.hms.entity.AppointmentEntity;
import com.cg.hms.exception.SlotNotAvailableException;
import com.cg.hms.model.AppointmentModel;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     Service Implementation class for Appointment

*******************************************************************************************************************************/

public class AppintmentServiceImpl implements AppointmentService{
	
	@Autowired
	AppointmentRepo appointmentRepo;

	@Override
	public AppointmentModel makeAppointment(AppointmentModel appointmentDto) throws SlotNotAvailableException {
		LocalTime time = appointmentDto.getDateTime().toLocalTime();
		if () {
			throw new SlotNotAvailableException("This slot is not available")
		}
		AppointmentEntity appointment = new AppointmentEntity();
		appointment.setUserId(appointmentDto.getUserId());
		appointment.setCentreId(appointmentDto.getCentreId());
		appointment.setDateTime(appointmentDto.getDateTime());
		appointment.setTestId(appointmentDto.getTestId());
		appointment.setStatus(appointmentDto.getStatus());
		
		appointmentDto.setAppointmentId(appointmentRepo.save(appointment).getAppointmentId());
		return appointmentDto;
	}
	
}
