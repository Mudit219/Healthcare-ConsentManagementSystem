package com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisRepositoryAPI;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisEntity.FortisEHealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FortisRepoAPI extends JpaRepository<FortisEHealthRecord,String> {

    public List<EHealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone);

    public EHealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId,String RecordIds);

    public List<EHealthRecord> findByAbhaId(String abhaId);

    public List<EHealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense);

}
