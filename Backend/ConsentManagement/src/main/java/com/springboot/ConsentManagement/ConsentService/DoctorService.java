package com.springboot.ConsentManagement.ConsentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ConsentManagement.ConsentDao.PatientRepository;
import com.springboot.ConsentManagement.ConsentDao.RecordRepository;
import com.springboot.ConsentManagement.Entities.EHealthRecord;
import com.springboot.ConsentManagement.Entities.Patient;

@Service
public class DoctorService {
	
	@Autowired
	private PatientRepository PatientHandler;
	
	@Autowired
	private RecordRepository RecordHandler;
	
	public List<EHealthRecord> accessRecords(String DoctorId,String PatientId,List<Long> RecordIds){
		Patient pat = this.PatientHandler.findByMetaId(PatientId);
		
		List<EHealthRecord> GrantedRecords = new ArrayList<EHealthRecord>();
		for(int i=0;i<RecordIds.size();i++) {			
			GrantedRecords.add(this.RecordHandler.findByPatientNameAndPatientPhoneAndEhrId(pat.getName(),pat.getPhone(),RecordIds.get(i)));
		}
		return GrantedRecords;
	}
}
