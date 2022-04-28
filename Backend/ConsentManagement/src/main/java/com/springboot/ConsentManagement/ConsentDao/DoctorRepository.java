package com.springboot.ConsentManagement.ConsentDao;

import com.springboot.ConsentManagement.Entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ConsentManagement.Entities.Doctor;
import com.springboot.ConsentManagement.Entities.Patient;

import java.util.Set;

public interface DoctorRepository extends JpaRepository<Doctor, String>{
	public Doctor findByMetaId(String doctorId);

	public Doctor findByNameAndDoctorLicense(String doctorName, String doctorLicense);

	public Set<Authority> findByAuthorities(String doctorId);

//	public Object findByNameAndPhone(String patientName, String patientPhone);
}
