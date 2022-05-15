package com.springboot.ConsentManagement.ConsentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
//import javafx.util.Pair;

import com.springboot.ConsentManagement.ContractService.ContractService;
import com.springboot.ConsentManagement.Entities.*;
import com.springboot.ConsentManagement.Security.AssignUserAuthorities;
import com.springboot.ConsentManagement.Security.ConsentUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.util.Pair;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.ConsentManagement.ConsentDao.DoctorRepository;
import com.springboot.ConsentManagement.ConsentDao.PatientRepository;
import com.springboot.ConsentManagement.ConsentDao.RecordRepository;

import javax.print.Doc;

@Service
public class DoctorService {
	
	@Autowired
	private PatientRepository PatientHandler;

	@Autowired
	@Qualifier("contractServiceConfiguration")
	ContractService contractService;
	@Autowired
	private RecordRepository RecordHandler;
	
	@Autowired
	private DoctorRepository DoctorHandler;


	List<EHealthRecord> GrantedRecords = new ArrayList<EHealthRecord>();

	
	public List<EHealthRecord> accessRecords(String DoctorId,List<ConsentedRecords> RecordIds){
		GrantedRecords.clear();
		this.accessGrantedRecords(DoctorId, RecordIds);
		this.accessOwnRecords(DoctorId);
		return GrantedRecords;
	}
	
	public void accessGrantedRecords(String DoctorId,List<ConsentedRecords> ConsentedRecords) {

		Patient pat = null;
		for (int i = 0; i < ConsentedRecords.size(); i++) {
			pat = this.PatientHandler.findByMetaId(ConsentedRecords.get(i).getPatientId());
			if (contractService.CheckValidRecords(DoctorId, ConsentedRecords.get(i).getRecordIds()) == Boolean.TRUE) {
				for (int j = 0; j < ConsentedRecords.get(i).getRecordIds().size(); j++) {
					this.GrantedRecords.add(this.RecordHandler.findByPatientNameAndAbhaIdAndEhrId(pat.getName(), pat.getAbhaId(), ConsentedRecords.get(i).getRecordIds().get(j)));
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
