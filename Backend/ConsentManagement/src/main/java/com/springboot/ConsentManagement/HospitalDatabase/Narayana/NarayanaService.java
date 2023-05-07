package com.springboot.ConsentManagement.HospitalDatabase.Narayana;

import com.springboot.ConsentManagement.ConsentService.HospitalService;
import com.springboot.ConsentManagement.Entities.HealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaEntity.NarayanaEHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaRepositoryAPI.NarayanaRepoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NarayanaService")
public class NarayanaService implements HospitalService {

    @Autowired
    private NarayanaRepoAPI narayanaRepoAPI;

    @Override
    public List<HealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone) {
        return null;
    }

    @Override
    public HealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId, String RecordIds) {
        return narayanaRepoAPI.findByPatientNameAndAbhaIdAndEhrId(patientName,abhaId,RecordIds);
    }

    @Override
    public List<NarayanaEHealthRecord> findByAbhaId(String abhaId) {
        return narayanaRepoAPI.findByAbhaId(abhaId);
//        return null;
    }

    @Override
    public List<NarayanaEHealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense) {

        return narayanaRepoAPI.findByDoctorNameAndDoctorLicense(name,doctorLicense);
    }

    @Override
    public List<? extends HealthRecord> findAll() {
        return narayanaRepoAPI.findAll();
    }

    @Override
    public List<String> findDistinctDoctorLicenseInRepo() {
        return null;
    }
}
