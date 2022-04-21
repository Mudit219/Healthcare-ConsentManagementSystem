package com.springboot.ConsentManagement.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


@Entity
@Table(name="EHealthRecords")
public class EHealthRecord {
	
	@Id
	private String ehrId;
	
	@Column(name="PatientName",nullable = false)
	private String patientName;
	
	@Column(name="DoctorName",nullable = false)
	private String doctorName;
	
	@Column(name="HospitalName",nullable = false)
	private String hospitalName;
	
	@Column(name="PatientPhone",nullable = false)
	private String patientPhone;
	
	@Column(name="Diagnosis",nullable = false)
	private String diagnosis;
	
	
	@Column(name="Date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
		
	@Column(name="Prescription")
	private String prescription;
	
	@Column(name="DoctorLicense")
	private String doctorLicense;
	
	
//	@Column(name="RecordLink")
//	private String recordLink;
//	
	public EHealthRecord() {
		super();
	}

	public String getEhrId() {
		return ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	public String getDoctorLicense() {
		return doctorLicense;
	}

	public void setDoctorLicense(String doctorLicense) {
		this.doctorLicense = doctorLicense;
	}
	
		
//	public String getRecordLink() {
//		return recordLink;
//	}

//	public void setRecordLink(String recordLink) {
//		this.recordLink = recordLink;
//	}

	public EHealthRecord(String ehrId, String doctorLicense,LocalDate date,String patientName, String patientPhone, String doctorName, String diagnosis, String hospitalName, String prescription) {
		super();
		this.ehrId = ehrId;
		this.patientName = patientName;
		this.patientPhone = patientPhone;
		this.doctorName = doctorName;
		this.diagnosis = diagnosis;
		this.hospitalName = hospitalName;
		this.date = date;
		this.prescription = prescription;
		this.doctorLicense = doctorLicense;
//		this.recordLink = recordLink;
	}
	
}