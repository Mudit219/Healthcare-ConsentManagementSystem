package com.springboot.ConsentManagement.ConsentService;

import java.util.List;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Patient;
import com.springboot.ConsentManagement.Entities.*;

public interface PatientService {
	public List<EHealthRecord> getPatientRecords(String metaId);
	public Patient getProfile(String metaId);
	public List<String> getDoctorNames(List<String> doctorIds);
	public String getPatientId(String name,String phone);

    PatientPublicProfile getPublicProfile(String metaId);

	List<PatientPublicProfile> getRequestedPublicProfiles(List<String> doctorIds);
//	public List<ConnectedDoctor> getConnections(String metaId);
}

