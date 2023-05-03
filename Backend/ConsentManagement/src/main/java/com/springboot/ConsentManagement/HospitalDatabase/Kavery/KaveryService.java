package com.springboot.ConsentManagement.HospitalDatabase.Kavery;

import com.springboot.ConsentManagement.ConsentService.HospitalService;
import com.springboot.ConsentManagement.Entities.HealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryEntity.KaveryEHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryRepositoryAPI.KaveryRepoAPI;
import org.checkerframework.framework.qual.QualifierArgument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("KaveryService")
public class KaveryService implements HospitalService {

    @Autowired
    private KaveryRepoAPI kaveryRepoAPI;

    @Override
    public List<HealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone) {
        return null;
    }

    @Override
    public HealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId, String RecordIds) {
        return kaveryRepoAPI.findByPatientNameAndAbhaIdAndEhrId(patientName,abhaId,RecordIds);
    }

    @Override
    public List<KaveryEHealthRecord> findByAbhaId(String abhaId) {
        return kaveryRepoAPI.findByAbhaId(abhaId);
    }

    @Override
    public List<HealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense) {
        return null;
    }

    @Override
    public List<? extends HealthRecord> findAll() {
        return kaveryRepoAPI.findAll();
    }
}
