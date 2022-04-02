package com.springboot.ConsentManagement.ConsentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ConsentManagement.ConsentService.DoctorService;
import com.springboot.ConsentManagement.Entities.EHealthRecord;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService DoctorServiceHandler;
	
	@GetMapping("/Doc_{metaId}/E-Health-Records")
	public List<EHealthRecord> accessRecords(@PathVariable("metaId") String metaId, @RequestParam("PatientId") String PatientId, @RequestParam("RecordIds") List<Long> RecordIds ){
		return this.DoctorServiceHandler.accessRecords(metaId, PatientId, RecordIds);
	}
}
