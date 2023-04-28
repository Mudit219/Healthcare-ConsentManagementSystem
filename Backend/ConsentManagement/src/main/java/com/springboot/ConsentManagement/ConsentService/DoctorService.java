package com.springboot.ConsentManagement.ConsentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//import javafx.util.Pair;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Doctor;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Patient;
import com.springboot.ConsentManagement.ContractService.ContractService;
import com.springboot.ConsentManagement.Entities.*;
import kotlin.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentDao.DoctorRepositoryAPI;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentDao.PatientRepositoryAPI;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentDao.RecordRepositoryAPI;

@Service
public class DoctorService {
	
	@Autowired
	private PatientRepositoryAPI PatientHandler;

	@Autowired
	@Qualifier("contractServiceConfiguration")
	ContractService contractService;
	@Autowired
	private RecordRepositoryAPI RecordHandler;
	
	@Autowired
	private DoctorRepositoryAPI DoctorHandler;


	List<EHealthRecord> GrantedRecords = new ArrayList<EHealthRecord>();

	
	public List<EHealthRecord> accessRecords(String DoctorId,List<ConsentedRecords> RecordIds){
		GrantedRecords.clear();
		this.accessGrantedRecords(DoctorId, RecordIds);
		this.accessOwnRecords(DoctorId);
		System.out.println("Here are some records:" + GrantedRecords);
		return GrantedRecords;
	}

	public void accessGrantedRecords(String DoctorId,List<ConsentedRecords> RecordIds){

		Patient pat = null;
		for(int i=0;i<RecordIds.size();i++) {
			pat = this.PatientHandler.findByMetaId(RecordIds.get(i).getPatientId());
			Pair<Boolean,Boolean> res = contractService.CheckValidRecords(DoctorId,RecordIds.get(i).getRecordIds());
			if(res.getFirst() == Boolean.TRUE && res.getSecond() == Boolean.TRUE) {
				for (int j = 0; j < RecordIds.get(i).getRecordIds().size(); j++) {
					this.GrantedRecords.add(this.RecordHandler.findByPatientNameAndAbhaIdAndEhrId(pat.getName(), pat.getAbhaId(), RecordIds.get(i).getRecordIds().get(j)));
				}
			}
		}
	}

	public void accessOwnRecords(String DoctorId){
		
		Doctor doc = this.DoctorHandler.findByMetaId(DoctorId);
		List<EHealthRecord> linkedWithDoc;
		linkedWithDoc = this.RecordHandler.findByDoctorNameAndDoctorLicense(doc.getName(),doc.getDoctorLicense());
		for(int i=0;i<linkedWithDoc.size();i++) {
			GrantedRecords.add(linkedWithDoc.get(i));
		}
	}
	
	public Doctor getProfile(String metaId) {
		return this.DoctorHandler.findByMetaId(metaId);
	}

	public DoctorPublicProfile getPublicProfile(String metaId){
		Doctor doc = this.DoctorHandler.findByMetaId(metaId);
		System.out.println(doc);
		if(doc != null) {
			DoctorPublicProfile profile = new DoctorPublicProfile(doc.getName(),
					doc.getSpecialization(),
					doc.getMetaId(),
					doc.getPhone(),
					doc.getEmail(),
					doc.getDoctorImage()
			);
			return profile;
		}
		else {
			return null;
		}

	}

	public List<DoctorPublicProfile> getRequestedPublicProfiles(List<String> doctorIds){
		return doctorIds.stream().filter(id->getPublicProfile(id)!=null)
				.map(id->getPublicProfile(id))
				.collect(Collectors.toList());
	}

	public List<ConnectedPatient> getConnections(String metaId) {
		GrantedRecords.clear();
		this.accessOwnRecords(metaId);
		List<ConnectedPatient> connections = new ArrayList<ConnectedPatient>();
		for(EHealthRecord e: GrantedRecords) {
			if(this.PatientHandler.findByNameAndPhone(e.getPatientName(), e.getPatientPhone())!=null){
				ConnectedPatient con = new ConnectedPatient(e.getPatientName(),e.getPatientPhone(),(this.PatientHandler.findByNameAndPhone(e.getPatientName(), e.getPatientPhone())).getMetaId());
				connections.add(con);
			}
		}
		return connections;
	}

}
