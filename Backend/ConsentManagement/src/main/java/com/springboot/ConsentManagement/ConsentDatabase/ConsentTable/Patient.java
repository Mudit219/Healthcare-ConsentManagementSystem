package com.springboot.ConsentManagement.ConsentDatabase.ConsentTable;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Authority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Patient")
public class Patient {
	
	@Column(name="patient_name",nullable = false)
	private String name;
	
	@Column(name="phone_number")
	private String phone;

	@Column(name="abha_id",nullable=false)
	private String abhaId;
	
	@Id
	@Column(name="meta_id")
	private String metaId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gender")
	private Character gender;
	
	@Column(name="patient_image")
	private String patientImage;

	@Column(name="password")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Authority> authorities;

	public Patient() {
		super();
	}

	public Patient(String name,
				   String phone,
				   String abhaId,
				   String metaId,
				   String email,
				   Character gender,
				   String patientImage,
				   String password,
				   Set<Authority> authorities) {
		this.name = name;
		this.phone = phone;
		this.abhaId = abhaId;
		this.metaId = metaId;
		this.email = email;
		this.gender = gender;
		this.patientImage = patientImage;
		this.password = password;
		this.authorities = authorities;
	}

	public String getAbhaId() {
		return this.abhaId;
	}

	public void setAbhaId(String abhaId) {
		this.abhaId = abhaId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPatientImage() {
		return patientImage;
	}
	
	public void setPatientImage(String patientImage) {
		this.patientImage = patientImage;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
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
