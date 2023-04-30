package com.springboot.ConsentManagement.ConsentDatabase.ConsentTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


@Entity
@Table(name="EHealth_Records")
public class EHealthRecord {
	
	@Id
	@Column(name="ehr_id")
	private String ehrId;

	@Column(name="abha_id",nullable = false)
	private String abhaId;
	
	@Column(name="patient_name",nullable = false)
	private String patientName;
	
	@Column(name="doctor_name",nullable = false)
	private String doctorName;
	
	@Column(name="hospital_name",nullable = false)
	private String hospitalName;
	
	@Column(name="patient_phone",nullable = false)
	private String patientPhone;
	
	@Column(name="diagnosis",nullable = false)
	private String diagnosis;
	
	
	@Column(name="date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
		
	@Column(name="prescription")
	private String prescription;
	
	@Column(name="doctor_license")
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

	public String getAbhaId() {
		return abhaId;
	}

	public void setAbhaId(String abhaId) {
		this.abhaId = abhaId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
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


	public EHealthRecord(String ehrId,
						 String abhaId,
						 String patientName,
						 String doctorName,
						 String hospitalName,
						 String patientPhone,
						 String diagnosis,
						 LocalDate date,
						 String prescription,
						 String doctorLicense) {
		this.ehrId = ehrId;
		this.abhaId = abhaId;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.hospitalName = hospitalName;
		this.patientPhone = patientPhone;
		this.diagnosis = diagnosis;
		this.date = date;
		this.prescription = prescription;
		this.doctorLicense = doctorLicense;
	}
}