package com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryRepositoryAPI;

import com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryEntity.KaveryEHealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KaveryRepoAPI extends JpaRepository<KaveryEHealthRecord,String> {
}
