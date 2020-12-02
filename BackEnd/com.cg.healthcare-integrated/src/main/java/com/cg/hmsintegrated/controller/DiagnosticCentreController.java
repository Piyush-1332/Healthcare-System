package com.cg.hmsintegrated.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hmsintegrated.entity.DiagnosticCentre;
import com.cg.hmsintegrated.exception.CentreException;
import com.cg.hmsintegrated.service.DiagnosticCentreServiceI;



@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/v1/diagnostic")
public class DiagnosticCentreController {
	
	@Autowired
	private DiagnosticCentreServiceI diagnosticCentreService;
	
	
	@GetMapping("/getCentre")
	public ResponseEntity<Object> getCentre() {
		return new ResponseEntity<>(diagnosticCentreService.viewCentre(), HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: addCentre Description: To add details of centre
	 * 
	 * @param addCentre Add centre details
	 * @mapping PostMapping Make HTTP request to post onto centre
	 * @throws CentreException It is raised due to centre id not present
	 ************************************************************************************/

	@PostMapping("/addCentre")
	public ResponseEntity<Object> addCentre(@RequestBody DiagnosticCentre diagnosticCentre) throws CentreException {

		try {
			diagnosticCentreService.addCentre(diagnosticCentre);
			return new ResponseEntity<>("Centre Added", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new CentreException("Centre Id already exists");
		}
	}

	/************************************************************************************
	 * Method: deleteCentre Description: To delete details of centre
	 * 
	 * @param deleteCentre Delete centre details
	 * @mapping @DeleteMapping Make HTTP request to delete centre by centre id
	 * @throws CentreException It is raised due to centre id not present
	 ************************************************************************************/

	@DeleteMapping("/deleteCentre/{centreId}")
	public ResponseEntity<Object> deleteCentre(@PathVariable("centreId") long centreId) throws CentreException {
		try {
			diagnosticCentreService.deleteCentre(centreId);
			return new ResponseEntity<>("Centre Deleted", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new CentreException("Can't delete centre");
		}

	}

	/************************************************************************************
	 * Method: updateCentre Description: To update details of centre
	 * 
	 * @param updateCentre Update centre details
	 * @mapping @DeleteMapping Make HTTP request to update centre by centre id
	 * @throws CentreException It is raised due to centre id not present
	 ************************************************************************************/

	@PutMapping("/updateCentre/{centreId}")
	public ResponseEntity<Object> updateCentre(@PathVariable("centreId") int centreId,
			@RequestBody DiagnosticCentre diagnosticCentre) throws CentreException {
		try {
			diagnosticCentreService.updateCentre(diagnosticCentre, centreId);
			return new ResponseEntity<>("Centre Updated", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new CentreException("Can't update centre");
		}
	}

	
	
	/************************************************************************************
	 * Method: viewCentreById Description: To get details of centre by id
	 * 
	 * @param viewCentreById Display centre details by id
	 * @mapping GetMapping Make HTTP request to get all centre
	 ************************************************************************************/

	@GetMapping("/viewcentrebyid/{centreId}")
	public ResponseEntity<Object> viewCentreById(@PathVariable("centreId") long centreId) {
		DiagnosticCentre diagnosticCentre = diagnosticCentreService.viewCentreById(centreId);
		return new ResponseEntity<Object>(diagnosticCentre, HttpStatus.OK);
	}

}
