package com.cg.hmsintegrated.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hmsintegrated.entity.AppointmentEntity;
import com.cg.hmsintegrated.entity.StatusEntity;
import com.cg.hmsintegrated.exception.AppointmentAlreadyApprovedException;
import com.cg.hmsintegrated.exception.AppointmentAlreadyDisapprovedException;
import com.cg.hmsintegrated.exception.AppointmentNotFoundException;
import com.cg.hmsintegrated.exception.SlotNotAvailableException;
import com.cg.hmsintegrated.model.AppointmentModel;
import com.cg.hmsintegrated.service.AppointmentService;

/*******************************************************************************************************************************
 * -Author					 : Piyush Srivastav 
 * -Created/Modified Date 	 : 26-11-2020 
 * -Description 			 : Appointment REST API controller
 * 
 *******************************************************************************************************************************/
@CrossOrigin(origins = "http://localhost:4200")
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
	
	@GetMapping("/viewmyappointment/{userId}")
	public ResponseEntity<List<AppointmentEntity>> viewMyAppointment(@PathVariable String userId)
			throws AppointmentNotFoundException {
		return new ResponseEntity<List<AppointmentEntity>>(appointmentService.getAllAppointmentsByUserId(userId),
				HttpStatus.OK);
	}

	@GetMapping("/viewallappointments")
	public ResponseEntity<List<AppointmentEntity>> viewAllAppointments()
			throws AppointmentNotFoundException {
		return new ResponseEntity<List<AppointmentEntity>>(appointmentService.viewAllAppointments(),
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
