package com.springboot.ConsentManagement.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EHealthRecords")
public class EHealthRecord {
	
	@Id
	private long EhrId;
	
	@Column(name="DoctorName",nullable = false)
	private String DoctorName;
	
	@Column(name="Diagonsis",nullable = false)
	private String Diagnosis;
	
	@Column(name="HospitalName",nullable = false)
	private String HospitalName;
	
	@Column(name="Date")
	private String Date;
	
	@Column(name="ConsentExpiry")
	private String ConsentExpiry;
	
	@Column(name="RecordLink")
	private String RecordLink;
	
	public EHealthRecord() {
		super();
	}
	
	public EHealthRecord(long ehrId, String doctorName, String diagnosis, String hospitalName, String date,
			String consentExpiry, String recordLink) {
		super();
		EhrId = ehrId;
		DoctorName = doctorName;
		Diagnosis = diagnosis;
		HospitalName = hospitalName;
		Date = date;
		ConsentExpiry = consentExpiry;
		RecordLink = recordLink;
	}
	
	
	public long getEhrId() {
		return EhrId;
	}
	public void setEhrId(int ehrId) {
		EhrId = ehrId;
	}
	public String getDoctorName() {
		return DoctorName;
	}
	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}
	public String getDiagnosis() {
		return Diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		Diagnosis = diagnosis;
	}
	public String getHospitalName() {
		return HospitalName;
	}
	public void setHospitalName(String hospitalName) {
		HospitalName = hospitalName;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getConsentExpiry() {
		return ConsentExpiry;
	}
	public void setConsentExpiry(String consentExpiry) {
		ConsentExpiry = consentExpiry;
	}
	public String getRecordLink() {
		return RecordLink;
	}
	public void setRecordLink(String recordLink) {
		RecordLink = recordLink;
	}
}
