package com.springboot.ConsentManagement.Entities;

public class ConnectedPatient {
	private String patientName;
	private String patientPhone;
	private String patientId;
	public ConnectedPatient(String patientName, String patientPhone,String patientId) {
		super();
		this.patientName = patientName;
		this.patientPhone = patientPhone;
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId= patientId;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	
	
}
