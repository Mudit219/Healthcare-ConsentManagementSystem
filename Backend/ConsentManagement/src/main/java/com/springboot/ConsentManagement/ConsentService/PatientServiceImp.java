package com.springboot.ConsentManagement.ConsentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Patient;
import com.springboot.ConsentManagement.Entities.*;
import com.springboot.ConsentManagement.HospitalFactory;
import com.springboot.ConsentManagement.Security.AssignUserAuthorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentDao.DoctorRepositoryAPI;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentDao.PatientRepositoryAPI;

@Service
public class PatientServiceImp implements PatientService{
	@Autowired
	private PatientRepositoryAPI PatientHandler;

	@Autowired
	private HospitalFactory hospitalFactory;
	@Autowired
	private DoctorRepositoryAPI DoctorHandler;

	@Autowired
	AssignUserAuthorities assignUserAuthorities;
	
	public PatientServiceImp() {
	}

	@Override
	public List<List<? extends HealthRecord>> getPatientRecords(String metaId,List<String> hospitalNames) {
		Patient pat = this.PatientHandler.findByMetaId(metaId);
		List<List<? extends HealthRecord>> patientRecordsList = hospitalNames.stream()
				.map(name ->
						hospitalFactory.getHospital(name).findByAbhaId(pat.getAbhaId()))
				.collect(Collectors.toList());
		patientRecordsList.stream()
				.forEach(recordList ->
				recordList.stream()
						.forEach(healthRecord ->
								healthRecord.setEhrId("#" + healthRecord.getHospitalName().split(" ")[0] + "-" + healthRecord.getEhrId())));

		patientRecordsList.forEach( recordlist -> recordlist.forEach( record -> System.out.println(record.getEhrId())));

		return patientRecordsList;
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
