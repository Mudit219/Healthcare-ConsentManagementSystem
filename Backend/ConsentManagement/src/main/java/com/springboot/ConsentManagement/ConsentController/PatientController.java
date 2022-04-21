package com.springboot.ConsentManagement.ConsentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ConsentManagement.ConsentService.PatientService;
import com.springboot.ConsentManagement.Entities.ConnectedDoctor;
import com.springboot.ConsentManagement.Entities.ConnectedPatient;
import com.springboot.ConsentManagement.Entities.EHealthRecord;
import com.springboot.ConsentManagement.Entities.Patient;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {
	
	@Autowired
	private PatientService ServiceHandler;
	
	@GetMapping(path="/Pat_{metaId}/E-Health-Records")
	public List<EHealthRecord> getPatientRecords(@PathVariable("metaId") String metaId){
		return this.ServiceHandler.getPatientRecords(metaId);
	}
	
	@GetMapping(path="/Pat_{metaId}/Profile")
	public Patient getProfile(@PathVariable("metaId") String metaId) {
		return this.ServiceHandler.getProfile(metaId);
		
	}
	
	@GetMapping(path="/Pat_{metaId}/Consents")
	public List<String> getDoctorNames(@PathVariable("metaId") String metaId, @RequestBody List<String> consentedDoctorIds) {
		return this.ServiceHandler.getDoctorNames(consentedDoctorIds);
		
	}
	
	@PostMapping(path="/AddPat_")
	public Patient addPatient(@RequestBody Patient patient) {
		return this.ServiceHandler.addPatient(patient);
	}
	
	@GetMapping(path="/Pat_{metaId}/Valid")
	public Boolean isPatientValid(@PathVariable("metaId") String metaId) {
		return this.ServiceHandler.isPatientValid(metaId);
	}
	
	@GetMapping(path="/Pat_{metaId}/Get-Connections")
	public List<ConnectedDoctor> getConnections(@PathVariable("metaId") String metaId) {
		return this.ServiceHandler.getConnections(metaId);	
	}
}
