package com.springboot.ConsentManagement.ConsentController;

import java.util.List;
import java.util.Set;

import com.springboot.ConsentManagement.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ConsentManagement.ConsentService.PatientService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {
	
	@Autowired
	private PatientService PatientServiceHandler;

	@PreAuthorize("#metaId == authentication.name and hasRole('ROLE_PATIENT')")
	@GetMapping(path="/Pat/{metaId}/E-Health-Records")
	public List<EHealthRecord> getPatientRecords(@PathVariable("metaId") String metaId){
		return this.PatientServiceHandler.getPatientRecords(metaId);
	}

	@GetMapping(path="/Pat/{metaId}/Consents")
	public List<String> getDoctorNames(@PathVariable("metaId") String metaId, @RequestBody List<String> consentedDoctorIds) {
		return this.PatientServiceHandler.getDoctorNames(consentedDoctorIds);

	}

	@PostMapping(path="/Pat/Profile-public")
	public List<PatientPublicProfile> getRequestedPublicProfile(@RequestBody List<String> patientIds) {
		return this.PatientServiceHandler.getRequestedPublicProfiles(patientIds);
	}

	@PreAuthorize("#metaId == authentication.name and hasRole('ROLE_PATIENT')")
	@GetMapping(path="/Pat/{metaId}/Profile")
	public Patient getProfile(@PathVariable("metaId") String metaId) {
		return this.PatientServiceHandler.getProfile(metaId);
	}

	@GetMapping(path="/Pat/{metaId}/Profile-public")
	public PatientPublicProfile getPublicProfile(@PathVariable("metaId") String metaId) {
		return this.PatientServiceHandler.getPublicProfile(metaId);
	}
}
