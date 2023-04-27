package com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaRepositoryAPI;

import com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaEntity.NarayanaEHealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NarayanaRepoAPI extends JpaRepository<NarayanaEHealthRecord,String> {

}
