package com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisRepositoryAPI;

import com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisEntity.FortisEHealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FortisRepoAPI extends JpaRepository<FortisEHealthRecord,String> {

}
