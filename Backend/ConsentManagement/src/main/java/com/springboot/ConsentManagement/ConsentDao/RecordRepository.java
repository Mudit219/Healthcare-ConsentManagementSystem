package com.springboot.ConsentManagement.ConsentDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ConsentManagement.Entities.EHealthRecord;

public interface RecordRepository extends JpaRepository<EHealthRecord, String> {
	
	public List<EHealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone);
	
	public EHealthRecord findByPatientNameAndPatientPhoneAndEhrId(String patientName, String patientPhone,String RecordIds);

	public List<EHealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense);
}
