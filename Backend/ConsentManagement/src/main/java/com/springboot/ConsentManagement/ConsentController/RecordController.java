package com.springboot.ConsentManagement.ConsentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ConsentManagement.ConsentService.RecordService;
import com.springboot.ConsentManagement.Entities.EHealthRecord;

@RestController
public class RecordController {
	
	@Autowired
	private RecordService ServiceHandler;
	
	@GetMapping(path="/E-Health-Records")
	public List<EHealthRecord> getRecords(){
		return this.ServiceHandler.getRecords();
	}
	
	@PostMapping(path="/E-Health-Records")
	public EHealthRecord addRecord(@RequestBody EHealthRecord rec) {
		return this.ServiceHandler.addRecord(rec);
	}
}
