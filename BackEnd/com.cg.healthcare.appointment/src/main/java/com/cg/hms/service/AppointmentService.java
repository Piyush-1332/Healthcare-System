package com.cg.hms.service;

import com.cg.hms.model.AppointmentModel;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     Service Interface for Appointment

*******************************************************************************************************************************/

public interface AppointmentService {
	AppointmentModel makeAppointment(AppointmentModel appointmentDto);
}
