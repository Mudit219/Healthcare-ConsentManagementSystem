package com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryRepositoryAPI;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryEntity.KaveryEHealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KaveryRepoAPI extends JpaRepository<KaveryEHealthRecord,String> {

    public List<EHealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone);

    public EHealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId,String RecordIds);

    public List<EHealthRecord> findByAbhaId(String abhaId);

    public List<EHealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense);
}
