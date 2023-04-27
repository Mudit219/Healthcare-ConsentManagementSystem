package com.springboot.ConsentManagement.ConsentDatabase.ConsentDao;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Patient;

import java.util.Set;

public interface PatientRepositoryAPI extends JpaRepository<Patient, String>{
	public Patient findByMetaId(String metaId);
	public Patient findByNameAndPhone(String name,String phone);

	public Patient findByAbhaId(String abhaId);
	public Patient findByPhone(String phone);
	public Set<Authority> findByAuthorities(String patientId);
}
