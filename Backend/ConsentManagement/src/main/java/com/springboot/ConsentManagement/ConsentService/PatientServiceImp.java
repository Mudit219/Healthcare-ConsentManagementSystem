package com.springboot.ConsentManagement.ConsentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.springboot.ConsentManagement.Entities.*;
import com.springboot.ConsentManagement.Security.AssignUserAuthorities;
import com.springboot.ConsentManagement.Security.ConsentUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ConsentManagement.ConsentDao.RecordRepository;
import com.springboot.ConsentManagement.ConsentDao.DoctorRepository;
import com.springboot.ConsentManagement.ConsentDao.PatientRepository;

@Service
public class PatientServiceImp implements PatientService{
	
	@Autowired
	private RecordRepository EHRecordHander;
	
	@Autowired
	private PatientRepository PatientHandler;
//	List<EHealthRecord> Records;
	
	@Autowired
	private DoctorRepository DoctorHandler;

	@Autowired
	AssignUserAuthorities assignUserAuthorities;
	
	public PatientServiceImp() {
	}

	@Override
	public List<EHealthRecord> getPatientRecords(String metaId) {
		Patient pat = this.PatientHandler.findByMetaId(metaId);
		return this.EHRecordHander.findByPatientNameAndPatientPhone(pat.getName(), pat.getPhone());
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

//	@Override
//	public List<ConnectedDoctor> getConnections(String metaId) {
//		List<EHealthRecord> patientRecords = new ArrayList<EHealthRecord>();
//		patientRecords = this.getPatientRecords(metaId);
//		List<ConnectedDoctor> connections = new ArrayList<ConnectedDoctor>();
//		for(EHealthRecord e: patientRecords) {
//			if(this.DoctorHandler.findByNameAndDoctorLicense(e.getDoctorName(), e.getDoctorLicense())!=null){
//				ConnectedDoctor con = new ConnectedDoctor(e.getDoctorName(),e.getDoctorLicense(),(this.DoctorHandler.findByNameAndDoctorLicense(e.getDoctorName(), e.getDoctorLicense())).getMetaId());
//				connections.add(con);
//			}
//		}
//		return connections;
//	}

}
