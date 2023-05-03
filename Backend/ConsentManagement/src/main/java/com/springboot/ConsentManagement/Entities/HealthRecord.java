package com.springboot.ConsentManagement.Entities;

public interface HealthRecord {

    String getEhrId();

    void setEhrId(String id);

    String getHospitalName();

    String getDoctorName();

    String getDoctorLicense();

}
