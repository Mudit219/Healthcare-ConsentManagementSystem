package com.springboot.ConsentManagement.ConsentDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ConsentManagement.Entities.Doctor;
import com.springboot.ConsentManagement.Entities.Patient;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
