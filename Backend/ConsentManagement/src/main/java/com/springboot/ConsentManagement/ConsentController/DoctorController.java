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
//@CrossOrigin(origins = "*")
public class DoctorController {
	
	@Autowired
	private DoctorService DoctorServiceHandler;
	
	@PreAuthorize("#metaId == authentication.name and hasRole('ROLE_DOCTOR')")
	@PostMapping("/Doc/{metaId}/E-Health-Records")
	public List<EHealthRecord> accessRecords(@PathVariable("metaId") String metaId,
											 @RequestBody List<ConsentedRecords> consentRecords ){
		return this.DoctorServiceHandler.accessRecords(metaId, consentRecords);
	}

	@PreAuthorize("(#metaId == authentication.name and hasRole('ROLE_DOCTOR'))")
	@GetMapping(path="/Doc/{metaId}/Profile")
	public Doctor getProfile(@PathVariable("metaId") String metaId) {
		return this.DoctorServiceHandler.getProfile(metaId);	
	}

	@GetMapping(path="/Doc/{metaId}/Profile-public")
	public DoctorPublicProfile getPublicProfile(@PathVariable("metaId") String metaId) {
		return this.DoctorServiceHandler.getPublicProfile(metaId);
	}

	@PostMapping(path="/Doc/Profile-public")
	public List<DoctorPublicProfile> getRequestedPublicProfile(@RequestBody List<String> doctorIds) {
		return this.DoctorServiceHandler.getRequestedPublicProfiles(doctorIds);
	}

	@GetMapping(path="/Doc/{metaId}/Get-Connections")
	public List<ConnectedPatient> getConnections(@PathVariable("metaId") String metaId) {
		return this.DoctorServiceHandler.getConnections(metaId);	
	}

}
