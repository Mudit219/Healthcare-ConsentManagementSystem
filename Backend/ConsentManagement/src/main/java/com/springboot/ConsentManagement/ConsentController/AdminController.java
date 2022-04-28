package com.springboot.ConsentManagement.ConsentController;

import com.springboot.ConsentManagement.ConsentService.AdminService;
import com.springboot.ConsentManagement.Entities.Authority;
import com.springboot.ConsentManagement.Entities.Doctor;
import com.springboot.ConsentManagement.Entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin("http://localhost:3000")
@RestController
public class AdminController {

    @Autowired
    private AdminService AdminServiceHandler;

    @GetMapping(path="/admin/Valid/Doc/{metaId}")
    public Boolean isDoctorValid(@PathVariable("metaId") String metaId) {
        return this.AdminServiceHandler.isDoctorValid(metaId);
    }

    @GetMapping(path="/admin/Valid/Pat/{metaId}")
    public Boolean isPatientValid(@PathVariable("metaId") String metaId) {
        return this.AdminServiceHandler.isPatientValid(metaId);
    }

    @PostMapping(path="/admin/AddDoc")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return this.AdminServiceHandler.addDoctor(doctor);
    }

    @PostMapping(path="/admin/AddPat")
    public Patient addPatient(@RequestBody Patient patient) {
        return this.AdminServiceHandler.addPatient(patient);
    }

    @PostMapping(path="/admin/Update-Authorities/{role}/{metaId}")
    public void updateAuthorities(@PathVariable("metaId") String metaId,
                                  @PathVariable("role") String role,
                                  @RequestBody Set<Authority> authorities){

        this.AdminServiceHandler.updateAuthorities(metaId,authorities,role);
    }

//    @PreAuthorize("permitAll()")
    @GetMapping(path="/admin/Get-Authorities/{role}/{metaId}")
    public Set<Authority> getAuthorities(@PathVariable("metaId") String metaId,
                                         @PathVariable("role") String role){

        return this.AdminServiceHandler.getAuthorities(metaId,role);
    }

}
