package com.springboot.ConsentManagement.ConsentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Patient;
import com.springboot.ConsentManagement.Entities.*;
import com.springboot.ConsentManagement.Security.AssignUserAuthorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentDao.RecordRepositoryAPI;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentDao.DoctorRepositoryAPI;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentDao.PatientRepositoryAPI;

@Service
public class PatientServiceImp implements PatientService{
	
	@Autowired
	private RecordRepositoryAPI EHRecordHander;
	
	@Autowired
	private PatientRepositoryAPI PatientHandler;
//	List<EHealthRecord> Records;
	
	@Autowired
	private DoctorRepositoryAPI DoctorHandler;

	@Autowired
	AssignUserAuthorities assignUserAuthorities;
	
	public PatientServiceImp() {
	}

	@Override
	public List<EHealthRecord> getPatientRecords(String metaId) {
		Patient pat = this.PatientHandler.findByMetaId(metaId);
//		return this.EHRecordHander.findByPatientNameAndPatientPhone(pat.getName(), pat.getPhone());
		return this.EHRecordHander.findByAbhaId(pat.getAbhaId());
	}

	@Override
	public Patient getProfile(String metaId) {
		return this.PatientHandler.findByMetaId(metaId);
	}

	@Override
	public List<String> getDoctorNames(List<String> doctorIds) {
		List<String> consentedDoctorNames = new ArrayList<String>();
		for(int i=0;i<doctorIds.size();i++)
			consentedDoctorNames.add(this.DoctorHandler.findByMetaId(doctorIds.get(i)).getName());
		return consentedDoctorNames;
	}

	@Override
	public String getPatientId(String name, String phone) {
		return (this.PatientHandler.findByNameAndPhone(name,phone)).getMetaId();
	}

	@Override
	public PatientPublicProfile getPublicProfile(String metaId) {
		Patient pat = this.PatientHandler.findByMetaId(metaId);
		if(pat != null) {
			PatientPublicProfile profile = new PatientPublicProfile(pat.getName(),
					pat.getMetaId(),pat.getPatientImage(),pat.getAbhaId());
			return profile;
		}
		else {
			return null;
		}

	}

	@Override
	public List<PatientPublicProfile> getRequestedPublicProfiles(List<String> patientIds) {
		return patientIds.stream().map(id->getPublicProfile(id)).collect(Collectors.toList());
	}
}
