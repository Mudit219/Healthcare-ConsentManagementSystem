package com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryRepositoryAPI;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryEntity.KaveryEHealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface KaveryRepoAPI extends JpaRepository<KaveryEHealthRecord,String> {

    public List<KaveryEHealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone);

    public KaveryEHealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId,String RecordIds);

    public List<KaveryEHealthRecord> findByAbhaId(String abhaId);

    public List<KaveryEHealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense);
}
