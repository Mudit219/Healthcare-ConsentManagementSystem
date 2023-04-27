package com.springboot.ConsentManagement.ConsentDatabase.ConsentDao;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Doctor;

import java.util.Set;

public interface DoctorRepositoryAPI extends JpaRepository<Doctor, String>{
	public Doctor findByMetaId(String doctorId);

	public Doctor findByNameAndDoctorLicense(String doctorName, String doctorLicense);

	public Set<Authority> findByAuthorities(String doctorId);

	public Doctor findByDoctorLicense(String license);

//	public Object findByNameAndPhone(String patientName, String patientPhone);
}
