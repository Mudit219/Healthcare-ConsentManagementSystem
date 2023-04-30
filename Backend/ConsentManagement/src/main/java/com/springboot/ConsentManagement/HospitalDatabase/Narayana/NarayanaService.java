package com.springboot.ConsentManagement.HospitalDatabase.Narayana;

import com.springboot.ConsentManagement.ConsentService.HospitalService;
import com.springboot.ConsentManagement.Entities.HealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaEntity.NarayanaEHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaRepositoryAPI.NarayanaRepoAPI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NarayanaService implements HospitalService {

    @Autowired
    private NarayanaRepoAPI narayanaRepoAPI;

    @Override
    public List<HealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone) {
        return null;
    }

    @Override
    public HealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId, String RecordIds) {
        return null;
    }

    @Override
    public List<NarayanaEHealthRecord> findByAbhaId(String abhaId) {
        return null;
    }

    @Override
    public List<HealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense) {
        return null;
    }
}
