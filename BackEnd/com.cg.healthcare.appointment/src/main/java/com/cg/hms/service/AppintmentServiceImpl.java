package com.cg.hms.service;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hms.dao.AppointmentRepo;
import com.cg.hms.entity.AppointmentEntity;
import com.cg.hms.entity.StatusEntity;
import com.cg.hms.exception.AppointmentAlreadyApprovedException;
import com.cg.hms.exception.AppointmentAlreadyDisapprovedException;
import com.cg.hms.exception.AppointmentNotFoundException;
import com.cg.hms.exception.SlotNotAvailableException;
import com.cg.hms.model.AppointmentModel;

/*******************************************************************************************************************************
 * -Author 				  :		Piyush Srivastav 
 * -Created/Modified Date :     26-11-2020 
 * -Description           :     Service Implementation class for Appointment
 *
 *******************************************************************************************************************************/
@Service
public class AppintmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepo appointmentRepo;

	@Override
	public AppointmentModel makeAppointment(AppointmentModel appointmentDto) throws SlotNotAvailableException {

		String str = appointmentDto.getDateTime();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

		
		LocalTime time = dateTime.toLocalTime();
		System.out.println(appointmentDto.getDateTime());
		System.out.println(time);
		if ( (appointmentRepo.getAppointmentBytestIdAndDateTime(appointmentDto.getDateTime(),appointmentDto.getTestId())!=null) || 
				(dateTime.isBefore(LocalDateTime.now().plusHours(1)) || dateTime.isAfter(LocalDateTime.now().plusMonths(3)) || 
						time.isBefore(LocalTime.of(6, 59)) || time.isAfter(LocalTime.of(21, 00)))) {
			throw new SlotNotAvailableException("This slot is not available");
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

	@Override
	public List<AppointmentEntity> getAllAppointments(String centreId) throws AppointmentNotFoundException {
		if (appointmentRepo.findAll(centreId).isEmpty()) {
			throw new AppointmentNotFoundException("No Appointment are registered under this Center");
		}
		
		return appointmentRepo.findAll(centreId);
		
	}

	@Override
	public AppointmentEntity viewAppointment(int appointmentId) throws AppointmentNotFoundException {
		
		if(!appointmentRepo.existsById(appointmentId)) {
			throw new AppointmentNotFoundException("Appointment with id" + appointmentId +" Not Found ");
		}
		return appointmentRepo.findById(appointmentId).get();
	}

	@Override
	public boolean removeAppointmentById(int appointmentId) throws AppointmentNotFoundException {
		if(!appointmentRepo.existsById(appointmentId)) {
			throw new AppointmentNotFoundException("Appointment with id" + appointmentId +" Not Found ");
		}
		else {
			appointmentRepo.deleteById(appointmentId);
			return true;
		}
	}


	@Override
	public AppointmentEntity approveAppointment(AppointmentEntity appointment, StatusEntity status) throws AppointmentAlreadyApprovedException {

		if (appointment.getStatus() == StatusEntity.approved) {
			throw new AppointmentAlreadyApprovedException(
					"Appointment with Id :" + appointment.getAppointmentId() + " is Already Approved");
		}
		appointment.setStatus(status);

		return appointmentRepo.save(appointment);

	}
	
	@Override
	public AppointmentEntity disapproveAppointment(AppointmentEntity appointment, StatusEntity status) throws AppointmentAlreadyDisapprovedException 
	{

		if (appointment.getStatus() == StatusEntity.disapproved)  {
			throw new AppointmentAlreadyDisapprovedException(
					"Appointment with Id :" + appointment.getAppointmentId() + "is Already Disapproved");
		}
		appointment.setStatus(status);

		return appointmentRepo.save(appointment);

	}
	

}
