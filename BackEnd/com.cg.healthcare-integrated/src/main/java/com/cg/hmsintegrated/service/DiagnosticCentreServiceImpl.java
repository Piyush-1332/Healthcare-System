package com.cg.hmsintegrated.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hmsintegrated.dao.DiagnosticCentreDAO;
import com.cg.hmsintegrated.entity.DiagnosticCentre;
import com.cg.hmsintegrated.exception.CentreException;

@Transactional
@Service
public class DiagnosticCentreServiceImpl implements DiagnosticCentreServiceI {

	@Autowired
	private DiagnosticCentreDAO diagnosticCentreDAO;

	@Override
	public boolean addCentre(DiagnosticCentre diagnosticCentre) throws CentreException {
		if (diagnosticCentreDAO.save(diagnosticCentre) != null) {
			return true;
		} else {
			throw new CentreException("Cannot add Centre, check id");
			}
	}

	@Override
	public boolean deleteCentre(long centreId) throws CentreException {

		if (!diagnosticCentreDAO.existsById(centreId)) {
			throw new CentreException("centre with id " + centreId + " Not Found ");
		} else {
			diagnosticCentreDAO.deleteById(centreId);
			return true;
		}
	}

	@Override
	public List<DiagnosticCentre> viewCentre() throws CentreException {

		try {
			return diagnosticCentreDAO.findAll();
		} catch (Exception e) {
			throw new CentreException("list empty");
		}
	}

	@Override
	public boolean updateCentre(DiagnosticCentre diagnosticCentre, long centreId) {

		if (diagnosticCentreDAO.save(diagnosticCentre) != null) {
			return true;
		} else
			throw new CentreException("Cannot update Centre, check id");
	}

	@Override
	public DiagnosticCentre viewCentreById(long centreId) throws CentreException {

		if (!diagnosticCentreDAO.findById(centreId).isPresent()) {
			throw new CentreException("Centre Id does not exxxiest");
		} else {
			return diagnosticCentreDAO.findById(centreId).orElse(null);
		}

	}

}
