package com.springboot.ConsentManagement.ConsentService;

import java.util.ArrayList;
import java.util.List;
//import javafx.util.Pair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.springboot.ConsentManagement.ConsentDao.DoctorRepository;
import com.springboot.ConsentManagement.ConsentDao.PatientRepository;
import com.springboot.ConsentManagement.ConsentDao.RecordRepository;
import com.springboot.ConsentManagement.Entities.ConnectedPatient;
import com.springboot.ConsentManagement.Entities.ConsentedRecords;
import com.springboot.ConsentManagement.Entities.Doctor;
import com.springboot.ConsentManagement.Entities.EHealthRecord;
import com.springboot.ConsentManagement.Entities.Patient;

@Service
public class DoctorService {
	
	@Autowired
	private PatientRepository PatientHandler;
	
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
	
	public void accessGrantedRecords(String DoctorId,List<ConsentedRecords> RecordIds){
		
		Patient pat = null;
		for(int i=0;i<RecordIds.size();i++) {
			pat = this.PatientHandler.findByMetaId(RecordIds.get(i).getPatientId());
			for(int j=0;j<RecordIds.get(i).getRecordIds().size();j++) {			
				this.GrantedRecords.add(this.RecordHandler.findByPatientNameAndPatientPhoneAndEhrId(pat.getName(),pat.getPhone(),RecordIds.get(i).getRecordIds().get(j)));
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
	
	public Boolean isDoctorValid(String metaId) {
		Doctor doc = this.DoctorHandler.findByMetaId(metaId);
		if(doc==null) return false;
		else return true;
	}
	
	public Doctor getProfile(String metaId) {
		return this.DoctorHandler.findByMetaId(metaId);
	}
	
	public Doctor addDoctor(Doctor doctor) {
		return this.DoctorHandler.save(doctor);
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
