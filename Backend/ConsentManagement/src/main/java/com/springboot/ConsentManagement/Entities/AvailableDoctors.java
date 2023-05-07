package com.springboot.ConsentManagement.Entities;

import java.util.Objects;

public class AvailableDoctors {
    private String hospitalName;
    private String doctorName;
    private String doctorSpecialization;
    private String doctorMetaId;

    public AvailableDoctors(String hospitalName, String doctorName, String doctorMetaId) {
        this.hospitalName = hospitalName;
        this.doctorName = doctorName;
        this.doctorMetaId = doctorMetaId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }


    public String getDoctorMetaId() {
        return doctorMetaId;
    }

    public void setDoctorMetaId(String doctorMetaId) {
        this.doctorMetaId = doctorMetaId;
    }
    @Override
    public int hashCode() {
        return Objects.hash(doctorMetaId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        AvailableDoctors other = (AvailableDoctors) obj;
        return Objects.equals(doctorMetaId, other.doctorMetaId) && Objects.equals(hospitalName, other.hospitalName);
    }
}
