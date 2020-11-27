package com.cg.hms.service;



import java.util.List;


import com.cg.hms.entity.AppointmentEntity;
import com.cg.hms.entity.StatusEntity;
import com.cg.hms.exception.AppointmentAlreadyApprovedException;
import com.cg.hms.exception.AppointmentAlreadyDisapprovedException;
import com.cg.hms.exception.AppointmentNotFoundException;
import com.cg.hms.exception.SlotNotAvailableException;
import com.cg.hms.model.AppointmentModel;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     Service Interface for Appointment

*******************************************************************************************************************************/

public interface AppointmentService {
	AppointmentModel makeAppointment(AppointmentModel appointmentDto) throws SlotNotAvailableException;
	
	List<AppointmentEntity> getAllAppointments (String centreId) throws AppointmentNotFoundException;

	AppointmentEntity viewAppointment(int appointmentId) throws AppointmentNotFoundException;
	
	boolean removeAppointmentById(int appointmentId) throws AppointmentNotFoundException;

	AppointmentEntity approveAppointment(AppointmentEntity appointment, StatusEntity status) throws AppointmentAlreadyApprovedException;

	AppointmentEntity disapproveAppointment(AppointmentEntity appointment, StatusEntity status) throws AppointmentAlreadyDisapprovedException;
}
