package com.springboot.ConsentManagement.ConsentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

	@Autowired
	AssignUserAuthorities assignUserAuthorities;
	
	List<EHealthRecord> GrantedRecords = new ArrayList<EHealthRecord>();

	
	public List<EHealthRecord> accessRecords(String DoctorId,List<ConsentedRecords> RecordIds){
		GrantedRecords.clear();
		this.accessGrantedRecords(DoctorId, RecordIds);
		this.accessOwnRecords(DoctorId);
		return GrantedRecords;
	}
	
	public void accessGrantedRecords(String DoctorId,List<ConsentedRecords> RecordIds){

		Patient pat = null;
		for(int i=0;i<RecordIds.size();i++) {
			pat = this.PatientHandler.findByMetaId(RecordIds.get(i).getPatientId());
			if(contractService.CheckValidRecords(DoctorId,RecordIds.get(i).getRecordIds()) == Boolean.TRUE) {
				for (int j = 0; j < RecordIds.get(i).getRecordIds().size(); j++) {
					this.GrantedRecords.add(this.RecordHandler.findByPatientNameAndPatientPhoneAndEhrId(pat.getName(), pat.getPhone(), RecordIds.get(i).getRecordIds().get(j)));
				}
			}
		}

//		System.out.println(RecordIds.size());
//		for(int i=2;i<RecordIds.size();i++) {
////			pat = this.PatientHandler.findByMetaId(RecordIds.get(i).getPatientId());
//			System.out.println(RecordIds.get(i).getRecordIds().size());
//			break;
//		}
	}
	
	public void accessOwnRecords(String DoctorId){
		
		Doctor doc = this.DoctorHandler.findByMetaId(DoctorId);
		List<EHealthRecord> linkedWithDoc;
		linkedWithDoc = this.RecordHandler.findByDoctorNameAndDoctorLicense(doc.getName(),doc.getDoctorLicense());
		for(int i=0;i<linkedWithDoc.size();i++) {
			GrantedRecords.add(linkedWithDoc.get(i));
		}
	}
	
//	public Boolean isDoctorValid(String metaId){
//		Doctor doc = this.DoctorHandler.findByMetaId(metaId);
//		if(doc==null) return false;
//		else return true;
//	}
	
	public Doctor getProfile(String metaId) {
		return this.DoctorHandler.findByMetaId(metaId);
	}

	public DoctorPublicProfile getPublicProfile(String metaId){
		Doctor doc = this.DoctorHandler.findByMetaId(metaId);
		DoctorPublicProfile profile = new DoctorPublicProfile(doc.getName(),
				doc.getSpecialization(),
				doc.getMetaId(),
				doc.getPhone(),
				doc.getEmail(),
				doc.getDoctorImage()
		);
		return profile;
	}
	
//	public Doctor addDoctor(Doctor doctor) {
//		doctor.setAuthorities(assignUserAuthorities.getGrantedAuthorities(ConsentUserRole.DOCTOR));
//		return this.DoctorHandler.save(doctor);
//	}

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


//	public void updateAuthorities(String metaId, Set<Authority> authorities) {
//		Doctor doc = this.DoctorHandler.findByMetaId(metaId);
//		Set<Authority> docAuthorities = doc.getAuthorities();
//		if(docAuthorities==null){
//			doc.setAuthorities(authorities);
//			this.DoctorHandler.save(doc);
//		}
//		else{
////			authorities.stream().map(auth -> docAuthorities.add(auth));
//			for(Authority auth: authorities){
//				docAuthorities.add(auth);
//			}
//			System.out.println(docAuthorities);
//			doc.setAuthorities(docAuthorities);
//			this.DoctorHandler.save(doc);
//		}
//	}
//
//	public Set<Authority> getAuthorities(String metaId) {
//		return (this.DoctorHandler.findByMetaId(metaId)).getAuthorities();
//	}
}
