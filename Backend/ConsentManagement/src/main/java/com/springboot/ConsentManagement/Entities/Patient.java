package com.springboot.ConsentManagement.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Patient")
public class Patient {
	
	@Column(name="PatientName",nullable = false)
	private String name;
	
	@Column(name="PhoneNumber",nullable = false)
	private long phone;
	
	@Id
	private String metaId;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Gender")
	private Character gender;
	
	public Patient() {
		super();
	}
	
	public Patient(String name, long phone, String metaId, String email, Character gender) {
		super();
		this.name = name;
		this.phone = phone;
		this.metaId = metaId;
		this.email = email;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getMetaId() {
		return metaId;
	}
	public void setMetaId(String metaId) {
		this.metaId = metaId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Character getGender() {
		return this.gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
}
