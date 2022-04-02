package com.springboot.ConsentManagement.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EHealthRecords")
public class EHealthRecord {
	
	@Id
	private long ehrId;
	
	@Column(name="PatientName",nullable = false)
	private String patientName;
	
	@Column(name="DoctorName",nullable = false)
	private String doctorName;
	
	@Column(name="HospitalName",nullable = false)
	private String hospitalName;
	
	@Column(name="PatientPhone",nullable = false)
	private long patientPhone;
	
	@Column(name="Diagnosis",nullable = false)
	private String diagnosis;
	
//	@Column(name="Date")
//	private String date;
	
	@Column(name="Prescription")
	private String prescription;
	
//	@Column(name="RecordLink")
//	private String recordLink;
//	
	public EHealthRecord() {
		super();
	}

	public long getEhrId() {
		return ehrId;
	}

	public void setEhrId(long ehrId) {
		this.ehrId = ehrId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public long getPaitentPhone() {
		return patientPhone;
	}

	public void setPaitentPhone(long patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String gethospitalName() {
		return hospitalName;
	}

	public void sethospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}

	public String getprescription() {
		return prescription;
	}

	public void setprescription(String prescription) {
		this.prescription = prescription;
	}

//	public String getRecordLink() {
//		return recordLink;
//	}

//	public void setRecordLink(String recordLink) {
//		this.recordLink = recordLink;
//	}

	public EHealthRecord(long ehrId, String patientName, long patientPhone, String doctorName, String diagnosis, String hospitalName, String prescription) {
		super();
		this.ehrId = ehrId;
		this.patientName = patientName;
		this.patientPhone = patientPhone;
		this.doctorName = doctorName;
		this.diagnosis = diagnosis;
		this.hospitalName = hospitalName;
//		this.date = date;
		this.prescription = prescription;
//		this.recordLink = recordLink;
	}
	
}