package com.springboot.ConsentManagement.ConsentDao;

import com.springboot.ConsentManagement.Entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ConsentManagement.Entities.Patient;

import java.util.Set;

public interface PatientRepository extends JpaRepository<Patient, String>{
	public Patient findByMetaId(String metaId);
	public Patient findByNameAndPhone(String name,String phone);
	public Set<Authority> findByAuthorities(String patientId);
}
