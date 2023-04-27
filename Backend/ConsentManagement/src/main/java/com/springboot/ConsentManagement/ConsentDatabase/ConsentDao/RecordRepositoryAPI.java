package com.springboot.ConsentManagement.ConsentDatabase.ConsentDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;

public interface RecordRepositoryAPI extends JpaRepository<EHealthRecord, String> {
	
	public List<EHealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone);
	
	public EHealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId,String RecordIds);

	public List<EHealthRecord> findByAbhaId(String abhaId);

	public List<EHealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense);
}
