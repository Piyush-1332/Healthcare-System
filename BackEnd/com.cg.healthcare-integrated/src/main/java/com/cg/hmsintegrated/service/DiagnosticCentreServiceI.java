package com.cg.hmsintegrated.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hmsintegrated.entity.DiagnosticCentre;
import com.cg.hmsintegrated.exception.CentreException;



@Service
public interface DiagnosticCentreServiceI {

	public boolean addCentre(DiagnosticCentre diagnosticCentre) throws CentreException;
	public boolean deleteCentre(long centreId) throws CentreException;
	List<DiagnosticCentre> viewCentre() throws CentreException;
	public boolean updateCentre(DiagnosticCentre diagnosticCentre,long centreId) throws CentreException;
	public DiagnosticCentre viewCentreById(long centreId) throws CentreException;


}