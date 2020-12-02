package com.cg.hmsintegrated.service;



import java.util.List;

import com.cg.hmsintegrated.entity.AppointmentEntity;
import com.cg.hmsintegrated.entity.StatusEntity;
import com.cg.hmsintegrated.exception.AppointmentAlreadyApprovedException;
import com.cg.hmsintegrated.exception.AppointmentAlreadyDisapprovedException;
import com.cg.hmsintegrated.exception.AppointmentNotFoundException;
import com.cg.hmsintegrated.exception.SlotNotAvailableException;
import com.cg.hmsintegrated.model.AppointmentModel;

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

	List<AppointmentEntity> getAllAppointmentsByUserId(String userId)throws AppointmentNotFoundException;

	List<AppointmentEntity> viewAllAppointments() throws AppointmentNotFoundException;
}
