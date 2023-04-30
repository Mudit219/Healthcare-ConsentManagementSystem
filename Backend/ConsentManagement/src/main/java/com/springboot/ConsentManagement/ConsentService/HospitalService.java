package com.springboot.ConsentManagement.ConsentService;

import com.springboot.ConsentManagement.Entities.HealthRecord;

import java.util.List;

public interface HospitalService {
    List<HealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone);

    HealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId,String RecordIds);

    List<? extends HealthRecord> findByAbhaId(String abhaId);

    List<HealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense);

}
