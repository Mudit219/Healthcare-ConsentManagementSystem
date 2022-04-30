package com.springboot.ConsentManagement.ConsentService;

import com.springboot.ConsentManagement.ConsentDao.DoctorRepository;
import com.springboot.ConsentManagement.ConsentDao.PatientRepository;
import com.springboot.ConsentManagement.ConsentDao.RecordRepository;
import com.springboot.ConsentManagement.ContractService.ContractService;
import com.springboot.ConsentManagement.Entities.*;
import com.springboot.ConsentManagement.Security.AssignUserAuthorities;
import com.springboot.ConsentManagement.Security.ConsentUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    @Qualifier("contractServiceConfiguration")
    ContractService contractService;
    @Autowired
    AssignUserAuthorities assignUserAuthorities;
    @Autowired
    private PatientRepository PatientHandler;

    @Autowired
    private RecordRepository RecordHandler;
    @Autowired
    private DoctorRepository DoctorHandler;

    public Boolean isDoctorValid(String metaId){
        Doctor doc = this.DoctorHandler.findByMetaId(metaId);
        if(doc==null) return false;
        else return true;
    }

    public Boolean isPatientValid(String metaId) {
        Patient pat = this.PatientHandler.findByMetaId(metaId);
        if(pat==null) return false;
        else return true;
    }

    public Doctor addDoctor(Doctor doc) {
        contractService.AddNewUserToContract(doc.getMetaId(),"doctor");
        doc.setAuthorities(assignUserAuthorities.getGrantedAuthorities(ConsentUserRole.DOCTOR));
        doc.setSpecialization("General");
        return this.DoctorHandler.save(doc);
    }

    public Patient addPatient(Patient patient) {
        contractService.AddNewUserToContract(patient.getMetaId(),"patient");
        patient.setAuthorities(assignUserAuthorities.getGrantedAuthorities(ConsentUserRole.PATIENT));
        return this.PatientHandler.save(patient);
    }


    public void updateAuthorities(String metaId, Set<Authority> authorities,String role) {
        if(role.equals("Doc")) {
            Doctor doc = this.DoctorHandler.findByMetaId(metaId);
            Set<Authority> docAuthorities = doc.getAuthorities();
            if (docAuthorities == null) {
                doc.setAuthorities(authorities);
                this.DoctorHandler.save(doc);
            } else {
//			authorities.stream().map(auth -> docAuthorities.add(auth));
                for (Authority auth : authorities) {
                    docAuthorities.add(auth);
                }
                System.out.println(docAuthorities);
                doc.setAuthorities(docAuthorities);
                this.DoctorHandler.save(doc);
            }
        }
        else{
            Patient pat = this.PatientHandler.findByMetaId(metaId);
            Set<Authority> patAuthorities = pat.getAuthorities();
            if (patAuthorities == null) {
                pat.setAuthorities(authorities);
                this.PatientHandler.save(pat);
            } else {
//			    authorities.stream().map(auth -> patAuthorities.add(auth));
                for (Authority auth : authorities) {
                    patAuthorities.add(auth);
                }
                System.out.println(patAuthorities);
                pat.setAuthorities(patAuthorities);
                this.PatientHandler.save(pat);
            }
        }
    }

    public Set<Authority> getAuthorities(String metaId,String role) {
        if(role.equals("Doc"))
            return (this.DoctorHandler.findByMetaId(metaId)).getAuthorities();
        return (this.PatientHandler.findByMetaId(metaId)).getAuthorities();
    }

    public Set<AvailableDoctors> getAvailableDoctors(){
        List<EHealthRecord> records = this.RecordHandler.findAll();
        Set<AvailableDoctors> availableDoctors = new HashSet<>();
        Doctor doc;
        for(int i=0;i<records.size();i++){
            doc = this.DoctorHandler.findByNameAndDoctorLicense(
                    records.get(i).getDoctorName(),
                    records.get(i).getDoctorLicense());
            if(doc!=null) {
                availableDoctors.add(new AvailableDoctors(records.get(i).gethospitalName(),
                        records.get(i).getDoctorName(),
                        doc.getSpecialization(), doc.getMetaId()));
            }
        }
        return availableDoctors.stream().distinct().collect(Collectors.toSet());
    }

}
