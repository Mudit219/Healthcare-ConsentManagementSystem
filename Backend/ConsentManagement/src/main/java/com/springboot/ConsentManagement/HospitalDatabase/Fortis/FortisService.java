package com.springboot.ConsentManagement.HospitalDatabase.Fortis;

import com.springboot.ConsentManagement.ConsentService.HospitalService;
import com.springboot.ConsentManagement.Entities.HealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisEntity.FortisEHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisRepositoryAPI.FortisRepoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FortisService")
public class FortisService implements HospitalService {

    @Autowired
    private FortisRepoAPI fortisRepoAPI;

    @Override
    public List<HealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone) {
        return null;
    }

    @Override
    public HealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId, String RecordIds) {
        return fortisRepoAPI.findByPatientNameAndAbhaIdAndEhrId(patientName,abhaId,RecordIds);
    }

    @Override
    public List<FortisEHealthRecord> findByAbhaId(String abhaId) {
        return fortisRepoAPI.findByAbhaId(abhaId);
//        return null;
    }

    @Override
    public List<HealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense) {
        return null;
    }

    @Override
    public List<? extends HealthRecord> findAll() {
        return fortisRepoAPI.findAll();
    }
}
