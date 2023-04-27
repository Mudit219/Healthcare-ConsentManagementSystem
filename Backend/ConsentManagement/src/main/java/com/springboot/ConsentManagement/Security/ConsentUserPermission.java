package com.springboot.ConsentManagement.Security;


// These are all the permissions available.
public enum ConsentUserPermission {
	PROFILE_PATIENT_READ("profile_patient:read"),
	PROFILE_PATIENT_WRITE("profile_patient:write"),
	PROFILE_DOCTOR_READ("profile_doctor:read"),
	PROFILE_DOCTOR_WRITE("profile_doctor:write"),
	RECORDS_DOCTOR_READ("records_doctor:read"),
	RECORDS_PATIENT_READ("records_patient:read");

	private final String permission;
	ConsentUserPermission(String permission) {
		this.permission = permission;
	}
	public String getPermission() {
		return permission;
	}
}
