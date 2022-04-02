package com.springboot.ConsentManagement.ConsentDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ConsentManagement.Entities.EHealthRecord;

public interface RecordRepository extends JpaRepository<EHealthRecord, Long> {
	
	public List<EHealthRecord> findByPatientNameAndPatientPhone(String patientName, long patientPhone);
	
	public EHealthRecord findByPatientNameAndPatientPhoneAndEhrId(String patientName, long patientPhone,long RecordIds);
}
