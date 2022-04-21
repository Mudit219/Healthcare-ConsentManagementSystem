package com.springboot.ConsentManagement.Entities;

public class ConnectedDoctor {
	private String doctorName;
	private String doctorLicense;
	private String doctorId;
	public ConnectedDoctor(String doctorName, String doctorPhone, String doctorId) {
		super();
		this.doctorName = doctorName;
		this.doctorLicense = doctorPhone;
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return this.doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorLicense() {
		return this.doctorLicense;
	}
	public void setDoctorLicense(String doctorLicense) {
		this.doctorLicense = doctorLicense;
	}
	public String getDoctorId() {
		return this.doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	
	
}
