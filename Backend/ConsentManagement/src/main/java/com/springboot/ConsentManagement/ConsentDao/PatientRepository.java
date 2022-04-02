package com.springboot.ConsentManagement.ConsentDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ConsentManagement.Entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	public Patient findByMetaId(String metaId);
}
