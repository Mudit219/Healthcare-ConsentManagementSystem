package com.springboot.ConsentManagement.ConsentDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ConsentManagement.Entities.Doctor;
import com.springboot.ConsentManagement.Entities.Patient;

public interface DoctorRepository extends JpaRepository<Doctor, String>{
	public Doctor findByMetaId(String doctorId);

	public Doctor findByNameAndDoctorLicense(String doctorName, String doctorLicense);

//	public Object findByNameAndPhone(String patientName, String patientPhone);
}
