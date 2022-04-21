package com.springboot.ConsentManagement.ConsentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ConsentManagement.ConsentService.DoctorService;
import com.springboot.ConsentManagement.Entities.ConnectedPatient;
import com.springboot.ConsentManagement.Entities.ConsentedRecords;
import com.springboot.ConsentManagement.Entities.Doctor;
import com.springboot.ConsentManagement.Entities.EHealthRecord;
import com.springboot.ConsentManagement.Entities.Patient;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorController {
	
	@Autowired
	private DoctorService DoctorServiceHandler;
	
	@PostMapping("/Doc_{metaId}/E-Health-Records")
	public List<EHealthRecord> accessRecords(@PathVariable("metaId") String metaId, @RequestBody List<ConsentedRecords> consentRecords ){
		return this.DoctorServiceHandler.accessRecords(metaId, consentRecords);
	}
	
	@GetMapping(path="/Doc_{metaId}/Valid")
	public Boolean isPatientValid(@PathVariable("metaId") String metaId) {
		return this.DoctorServiceHandler.isDoctorValid(metaId);
	}
	
	@GetMapping(path="/Doc_{metaId}/Profile")
	public Doctor getProfile(@PathVariable("metaId") String metaId) {
		return this.DoctorServiceHandler.getProfile(metaId);	
	}
	
	@PostMapping(path="/AddDoc_")
	public Doctor addPatient(@RequestBody Doctor doctor) {
		return this.DoctorServiceHandler.addDoctor(doctor);
	}
	
	@GetMapping(path="/Doc_{metaId}/Get-Connections")
	public List<ConnectedPatient> getConnections(@PathVariable("metaId") String metaId) {
		return this.DoctorServiceHandler.getConnections(metaId);	
	}
	
}
