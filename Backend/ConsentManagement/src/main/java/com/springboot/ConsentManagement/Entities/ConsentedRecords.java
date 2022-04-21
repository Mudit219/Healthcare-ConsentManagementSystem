package com.springboot.ConsentManagement.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

public class ConsentedRecords {
	
	private String patientId;
	
	private List<String> recordIds;
	
	public ConsentedRecords() {
		super();
	}
	
	public ConsentedRecords(String patientId, List<String> recordIds) {
		super();
		this.patientId = patientId;
		this.recordIds = recordIds;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public List<String> getRecordIds() {
		return this.recordIds;
	}
	public void setRecordIds(List<String> recordIds) {
		this.recordIds = recordIds;
	}
}
