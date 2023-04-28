package com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaRepositoryAPI;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaEntity.NarayanaEHealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NarayanaRepoAPI extends JpaRepository<NarayanaEHealthRecord,String> {

    public List<EHealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone);

    public EHealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId,String RecordIds);

    public List<EHealthRecord> findByAbhaId(String abhaId);

    public List<EHealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense);

}
