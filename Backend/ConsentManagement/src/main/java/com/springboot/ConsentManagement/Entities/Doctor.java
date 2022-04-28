package com.springboot.ConsentManagement.Entities;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Doctor")
public class Doctor {
	
	@Column(name="DoctorName",nullable = false)
	private String name;
	
	@Column(name="PhoneNumber")
	private String phone;
	
	@Id
	private String metaId;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Gender")
	private Character gender;
	
	@Column(name="Specialization")
	private String specialization;
	
	@Column(name="DoctorLicense",nullable = false)
	private String doctorLicense;
	
	@Column(name="DoctorImage")
	private String doctorImage;

	@Column(name="Password")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Authority> authorities;

	public Doctor() {
		super();
	}

	public Doctor(String name,
				  String phone,
				  String metaId,
				  String email,
				  Character gender,
				  String specialization,
				  String doctorLicense,
				  String doctorImage,
				  String password,
				  Set<Authority> authorities
	) {
		this.name = name;
		this.phone = phone;
		this.metaId = metaId;
		this.email = email;
		this.gender = gender;
		this.specialization = specialization;
		this.doctorLicense = doctorLicense;
		this.doctorImage = doctorImage;
		this.password = password;
		this.authorities = authorities;
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
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDoctorLicense() {
		return doctorLicense;
	}

	public void setDoctorLicense(String doctorLicense) {
		this.doctorLicense = doctorLicense;
	}

	public String getDoctorImage() {
		return doctorImage;
	}

	public void setDoctorImage(String doctorImage) {
		this.doctorImage = doctorImage;
	}
	
		
	
}
