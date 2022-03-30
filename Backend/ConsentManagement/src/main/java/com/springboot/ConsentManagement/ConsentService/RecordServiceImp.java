package com.springboot.ConsentManagement.ConsentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ConsentManagement.ConsentDao.ConsentDao;
import com.springboot.ConsentManagement.Entities.EHealthRecord;

@Service
public class RecordServiceImp implements RecordService{
	
	@Autowired
	private ConsentDao DaoHander;
//	List<EHealthRecord> Records;
	public RecordServiceImp() {
//		Records = new ArrayList<EHealthRecord>();
//		this.Records.add(new EHealthRecord(1, "Ramesh", "Headache", "Nimhans", "", "", ""));
//		this.Records.add(new EHealthRecord(2, "Ramesh", "Cold", "Nimhans", "", "", ""));
//		this.Records.add(new EHealthRecord(3, "Ramesh", "Ankle Injury", "Nimhans", "", "", ""));
//		this.Records.add(new EHealthRecord(4, "Ramesh", "Allergy", "Nimhans", "", "", ""));
	}

	@Override
	public List<EHealthRecord> getRecords() {
		return this.DaoHander.findAll();
	}

	@Override
	public EHealthRecord addRecord(EHealthRecord rec) {
		return this.DaoHander.save(rec);
	}

}
