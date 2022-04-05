package com.springboot.ConsentManagement.ConsentService;

import java.util.List;

import com.springboot.ConsentManagement.Entities.EHealthRecord;
import com.springboot.ConsentManagement.Entities.Patient;

public interface PatientService {
	public List<EHealthRecord> getPatientRecords(String metaId);
	public Patient getProfile(String metaId);
}
