package com.springboot.ConsentManagement.ConsentService;

import java.util.List;

import com.springboot.ConsentManagement.Entities.EHealthRecord;

public interface RecordService {
	public List<EHealthRecord> getRecords();
	public EHealthRecord addRecord(EHealthRecord rec);
}
