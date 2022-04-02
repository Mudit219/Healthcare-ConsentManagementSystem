package com.springboot.ConsentManagement.ConsentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ConsentManagement.ConsentDao.RecordRepository;
import com.springboot.ConsentManagement.ConsentDao.PatientRepository;
import com.springboot.ConsentManagement.Entities.EHealthRecord;
import com.springboot.ConsentManagement.Entities.Patient;

@Service
public class RecordServiceImp implements RecordService{
	
	@Autowired
	private RecordRepository EHRecordHander;
	
	@Autowired
	private PatientRepository PatientHandler;
//	List<EHealthRecord> Records;
	public RecordServiceImp() {
//		Records = new ArrayList<EHealthRecord>();
//		this.Records.add(new EHealthRecord(1, "Ramesh", "Headache", "Nimhans", "", "", ""));
//		this.Records.add(new EHealthRecord(2, "Ramesh", "Cold", "Nimhans", "", "", ""));
//		this.Records.add(new EHealthRecord(3, "Ramesh", "Ankle Injury", "Nimhans", "", "", ""));
//		this.Records.add(new EHealthRecord(4, "Ramesh", "Allergy", "Nimhans", "", "", ""));
	}

	@Override
	public List<EHealthRecord> getPatientRecords(String metaId) {
		Patient pat = this.PatientHandler.findByMetaId(metaId);
		return this.EHRecordHander.findByPatientNameAndPatientPhone(pat.getName(), pat.getPhone());
	}

}
