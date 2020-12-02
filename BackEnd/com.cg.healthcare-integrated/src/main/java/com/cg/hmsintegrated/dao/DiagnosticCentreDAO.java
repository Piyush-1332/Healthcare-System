package com.cg.hmsintegrated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hmsintegrated.entity.DiagnosticCentre;

@Repository
public interface DiagnosticCentreDAO extends JpaRepository<DiagnosticCentre, Long>{
	

}
