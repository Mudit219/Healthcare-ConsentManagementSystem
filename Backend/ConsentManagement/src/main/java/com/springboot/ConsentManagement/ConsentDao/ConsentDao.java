package com.springboot.ConsentManagement.ConsentDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ConsentManagement.Entities.EHealthRecord;

public interface ConsentDao extends JpaRepository<EHealthRecord, Long> {

}
