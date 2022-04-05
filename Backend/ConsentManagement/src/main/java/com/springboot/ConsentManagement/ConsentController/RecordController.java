package com.springboot.ConsentManagement.ConsentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ConsentManagement.ConsentService.RecordService;
import com.springboot.ConsentManagement.Entities.EHealthRecord;
import com.springboot.ConsentManagement.Entities.Patient;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RecordController {
	
	@Autowired
	private RecordService ServiceHandler;
	
	@GetMapping(path="/Pat_{metaId}/E-Health-Records")
	public List<EHealthRecord> getPatientRecords(@PathVariable("metaId") String metaId){
		return this.ServiceHandler.getPatientRecords(metaId);
	}
}
