package com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisEntity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.ConsentManagement.Entities.HealthRecord;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="EHealth_Records")
public class FortisEHealthRecord implements HealthRecord{

    @Id
    @Column(name="ehr_id")
    private String ehrId;

    @Column(name="abha_id",nullable = false)
    private String abhaId;

    @Column(name="patient_name",nullable = false)
    private String patientName;

    @Column(name="doctor_name",nullable = false)
    private String doctorName;

    @Column(name="hospital_name",nullable = false)
    private String hospitalName;

    @Column(name="patient_phone",nullable = false)
    private String patientPhone;

    @Column(name="diagnosis",nullable = false)
    private String diagnosis;

    @Column(name="date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

    @Column(name="prescription")
    private String prescription;

    @Column(name="doctor_license")
    private String doctorLicense;

}
