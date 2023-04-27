package com.springboot.ConsentManagement.Security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

import static com.springboot.ConsentManagement.Security.ConsentUserPermission.*;


// Defining different user roles. For each user Role there will some set of permissions/authorities.
public enum ConsentUserRole {
	PATIENT(Sets.newHashSet(PROFILE_PATIENT_READ,PROFILE_PATIENT_WRITE,RECORDS_PATIENT_READ)),

	DOCTOR(Sets.newHashSet(PROFILE_DOCTOR_READ,PROFILE_DOCTOR_WRITE,RECORDS_DOCTOR_READ));
	
	private final Set<ConsentUserPermission> permissions;
	
	private ConsentUserRole(Set<ConsentUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ConsentUserPermission> getPermissions() {
		return permissions;
	}
	
	// This conversion is needed to use these permissions in authorities function.
	public Set<SimpleGrantedAuthority> getSimpleGrantedAuthorities(){
		Set<SimpleGrantedAuthority> authorities = this.getPermissions()
				.stream().map(perm-> new SimpleGrantedAuthority(perm.getPermission()))
				.collect(Collectors.toSet());
		authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return authorities;
	}

//	public Set<Authority> getGrantedAuthorities(){
//		System.out.println("Heeklekrjke");
//		System.out.println(this.getPermissions().size()+"hfhfjkasd");
//		Authority temp = this.authorityRepo.findByAuthority(PROFILE_DOCTOR_READ.getPermission());
//		System.out.println(temp.getAuthority());
////		Set<Authority> authorities = this.getPermissions()
////				.stream()
////				.map(permission ->
////						this.authorityRepo.findByAuthority(permission.getPermission())).collect(Collectors.toSet());
//
//		Set<Authority> authorities = new HashSet<>();
//		authorities.add(new Authority("ROLE_"+this.name()));
//		return authorities;
//	}

}
