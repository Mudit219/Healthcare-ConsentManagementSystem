package com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisRepositoryAPI;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;
import com.springboot.ConsentManagement.Entities.HealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisEntity.FortisEHealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface FortisRepoAPI extends JpaRepository<FortisEHealthRecord,String> {

    public List<FortisEHealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone);

    public FortisEHealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId,String RecordIds);

    public List<FortisEHealthRecord> findByAbhaId(String abhaId);

    public List<FortisEHealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense);

}
