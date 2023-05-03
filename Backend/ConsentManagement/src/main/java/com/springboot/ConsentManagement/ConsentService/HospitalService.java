package com.springboot.ConsentManagement.ConsentService;

import com.springboot.ConsentManagement.Entities.HealthRecord;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HospitalService {
    List<? extends HealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone);

    <T extends HealthRecord> T findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId,String RecordIds);

    List<? extends HealthRecord> findByAbhaId(String abhaId);

    List<? extends HealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense);

    List<? extends HealthRecord> findAll();

}
