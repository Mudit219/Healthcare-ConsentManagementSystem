package com.springboot.ConsentManagement.ConsentController;

import java.util.List;
import java.util.Set;

import com.springboot.ConsentManagement.Entities.*;
import com.springboot.ConsentManagement.Security.ConsentUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ConsentManagement.ConsentService.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorController {
	
	@Autowired
	private DoctorService DoctorServiceHandler;
	
	@PreAuthorize("#metaId == authentication.name and hasRole('ROLE_DOCTOR')")
	@PostMapping("/Doc/{metaId}/E-Health-Records")
	public List<EHealthRecord> accessRecords(@PathVariable("metaId") String metaId, @RequestBody List<ConsentedRecords> consentRecords ){
		return this.DoctorServiceHandler.accessRecords(metaId, consentRecords);
	}

	@GetMapping(path="/Doc/{metaId}/Valid")
	public Boolean isDoctorValid(@PathVariable("metaId") String metaId) {
		return this.DoctorServiceHandler.isDoctorValid(metaId);
	}
	
	@PreAuthorize("#metaId == authentication.name and hasRole('ROLE_DOCTOR')")
	@GetMapping(path="/Doc/{metaId}/Profile")
	public Doctor getProfile(@PathVariable("metaId") String metaId) {
		return this.DoctorServiceHandler.getProfile(metaId);	
	}
	
	@PostMapping(path="/AddDoc")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return this.DoctorServiceHandler.addDoctor(doctor);
	}
	
	@GetMapping(path="/Doc/{metaId}/Get-Connections")
	public List<ConnectedPatient> getConnections(@PathVariable("metaId") String metaId) {
		return this.DoctorServiceHandler.getConnections(metaId);	
	}

	@PostMapping(path="/Doc/{metaId}/Update-Authorities")
	public void updateAuthorities(@PathVariable("metaId") String metaId, @RequestBody Set<Authority> authorities){
		this.DoctorServiceHandler.updateAuthorities(metaId,authorities);
	}

	@GetMapping(path="/Doc/{metaId}/Get-Authorities")
	public Set<Authority> getAuthorities(@PathVariable("metaId") String metaId){
		return this.DoctorServiceHandler.getAuthorities(metaId);
	}
}
