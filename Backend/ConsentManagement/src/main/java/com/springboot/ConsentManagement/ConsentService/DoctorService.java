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
import com.springboot.ConsentManagement.HospitalFactory;
import kotlin.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentDao.DoctorRepositoryAPI;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentDao.PatientRepositoryAPI;

@Service
public class DoctorService {
	
	@Autowired
	private PatientRepositoryAPI PatientHandler;

	@Autowired
	@Qualifier("contractServiceConfiguration")
	ContractService contractService;

	@Autowired
	private HospitalFactory hospitalFactory;
	
	@Autowired
	private DoctorRepositoryAPI DoctorHandler;


	List<HealthRecord> GrantedRecords = new ArrayList<>();

	
	public List<HealthRecord> accessRecords(String DoctorId,List<ConsentedRecords> RecordIds,List<String> hospitalNames){
		GrantedRecords.clear();
		this.accessGrantedRecords(DoctorId, RecordIds);
		this.accessOwnRecords(DoctorId,hospitalNames);
		System.out.println("Here are some records:" + GrantedRecords);
		return GrantedRecords;
	}

	public void accessGrantedRecords(String DoctorId,List<ConsentedRecords> RecordIds){

		Patient pat = null;
		for(int i=0;i<RecordIds.size();i++) {
			pat = this.PatientHandler.findByMetaId(RecordIds.get(i).getPatientId());
			System.out.println("Consented Records" + RecordIds.size());
			Pair<Boolean,Boolean> res = contractService.CheckValidRecords(DoctorId,RecordIds.get(i).getRecordIds());
			if(res.getFirst() == Boolean.TRUE && res.getSecond() == Boolean.TRUE) {
				for (int j = 0; j < RecordIds.get(i).getRecordIds().size(); j++) {
					String recordId = RecordIds.get(i).getRecordIds().get(j);
					String hospName = recordId.split("-")[0].replace("#","");
					String hospRecId = recordId.split("-")[1];

					System.out.println("-x-x--x-x-x-x-x-x--x-x-x-x--x-x--x");
					System.out.println("Hospital Name is here" + hospName);
					System.out.println("-x-x--x-x-x-x-x-x--x-x-x-x--x-x--x");

					HealthRecord ConsentedRecord = hospitalFactory.getHospital(hospName).findByPatientNameAndAbhaIdAndEhrId(pat.getName(), pat.getAbhaId(),hospRecId);
					ConsentedRecord.setEhrId("#" + hospName + "-" + hospRecId);
					this.GrantedRecords.add(ConsentedRecord);

				}
			}
		}
	}

	public void accessOwnRecords(String DoctorId,List<String> hospitalNames){
		
		Doctor doc = this.DoctorHandler.findByMetaId(DoctorId);
		List<List<? extends HealthRecord>> recordsLinkedWithDoc;

//		System.out.println("Hospital names are hereeee");
//		hospitalNames.forEach(System.out::println);

		if(hospitalNames.size() == 0 || hospitalNames == null) {
			return;
		}

		recordsLinkedWithDoc = hospitalNames.stream()
				.filter(name -> hospitalFactory.getHospital(name) != null)
				.map(name ->
						hospitalFactory.getHospital(name).findByDoctorNameAndDoctorLicense(doc.getName(),doc.getDoctorLicense())
				)
				.collect(Collectors.toList());

		recordsLinkedWithDoc.stream()
				.forEach(recordList ->
						recordList.stream()
								.forEach(healthRecord ->
										healthRecord.setEhrId("#" + healthRecord.getHospitalName().split(" ")[0] + "-" + healthRecord.getEhrId())));

//		System.out.println("Printing own records hereeee");
//		recordsLinkedWithDoc.stream().forEach(recordList -> recordList.forEach(record -> System.out.println(record)));

		recordsLinkedWithDoc.stream().forEach(recordList -> recordList.forEach(record -> GrantedRecords.add((HealthRecord)record)));

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
//		GrantedRecords.clear();
//		this.accessOwnRecords(metaId);
//		List<ConnectedPatient> connections = new ArrayList<ConnectedPatient>();
//		for(EHealthRecord e: GrantedRecords) {
//			if(this.PatientHandler.findByNameAndPhone(e.getPatientName(), e.getPatientPhone())!=null){
//				ConnectedPatient con = new ConnectedPatient(e.getPatientName(),e.getPatientPhone(),(this.PatientHandler.findByNameAndPhone(e.getPatientName(), e.getPatientPhone())).getMetaId());
//				connections.add(con);
//			}
//		}
//		return connections;
		return null;
	}

}
