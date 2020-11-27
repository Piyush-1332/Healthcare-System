package com.cg.hms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hms.entity.StatusEntity;
import com.cg.hms.entity.AppointmentEntity;
import com.cg.hms.exception.AppointmentAlreadyApprovedException;
import com.cg.hms.exception.AppointmentAlreadyDisapprovedException;
import com.cg.hms.exception.AppointmentNotFoundException;
import com.cg.hms.exception.SlotNotAvailableException;
import com.cg.hms.model.AppointmentModel;
import com.cg.hms.service.AppointmentService;

/*******************************************************************************************************************************
 * -Author					 : Piyush Srivastav 
 * -Created/Modified Date 	 : 26-11-2020 
 * -Description 			 : Appointment REST API controller
 * 
 *******************************************************************************************************************************/

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/makeappointment")
	public ResponseEntity<AppointmentModel> makeAppointment(@RequestBody AppointmentModel appointmentDto)
			throws SlotNotAvailableException {
		return new ResponseEntity<>(appointmentService.makeAppointment(appointmentDto), HttpStatus.OK);
	}

	@GetMapping("/getappointment/{centreId}")
	public ResponseEntity<List<AppointmentEntity>> getAllAppointments(@PathVariable String centreId)
			throws AppointmentNotFoundException {
		return new ResponseEntity<List<AppointmentEntity>>(appointmentService.getAllAppointments(centreId),
				HttpStatus.OK);
	}

	@GetMapping("/viewappointment/{appointmentId}")
	public ResponseEntity<AppointmentEntity> viewAppointment(@PathVariable int appointmentId)
			throws AppointmentNotFoundException {
		return new ResponseEntity<AppointmentEntity>(appointmentService.viewAppointment(appointmentId), HttpStatus.OK);

	}
	
	@DeleteMapping("/removeappointment/{appointmentId}")
	public ResponseEntity<?> removeAppointment(@PathVariable int appointmentId) throws AppointmentNotFoundException
	{
		return new ResponseEntity<>(appointmentService.removeAppointmentById(appointmentId),HttpStatus.OK);
	}
	
	@GetMapping("/approveappointment/{appointmentId}/{status}")
	public AppointmentEntity approveAppoinment(@PathVariable int appointmentId, @PathVariable StatusEntity status)throws AppointmentAlreadyApprovedException, AppointmentNotFoundException 
	{
		AppointmentEntity appointment = appointmentService.viewAppointment(appointmentId);
		return appointmentService.approveAppointment(appointment, status);
	}
	
	@GetMapping("/disapproveappointment/{appointmentId}/{status}")
	public AppointmentEntity disapproveAppoinment(@PathVariable int appointmentId, @PathVariable StatusEntity status) throws AppointmentAlreadyDisapprovedException, AppointmentNotFoundException
	{
		AppointmentEntity appointment = appointmentService.viewAppointment(appointmentId);
		return appointmentService.disapproveAppointment(appointment, status);
	}
	

}
