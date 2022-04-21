package com.springboot.ConsentManagement.ConsentService;

import java.util.List;

import com.springboot.ConsentManagement.Entities.ConnectedDoctor;
import com.springboot.ConsentManagement.Entities.ConnectedPatient;
import com.springboot.ConsentManagement.Entities.EHealthRecord;
import com.springboot.ConsentManagement.Entities.Patient;

public interface PatientService {
	public List<EHealthRecord> getPatientRecords(String metaId);
	public Patient getProfile(String metaId);
	public List<String> getDoctorNames(List<String> doctorIds);
	public Patient addPatient(Patient patient);
	public Boolean isPatientValid(String metaId);
	public String getPatientId(String name,String phone);
	public List<ConnectedDoctor> getConnections(String metaId);

}
