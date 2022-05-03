package com.springboot.ConsentManagement.ConsentController;

import com.springboot.ConsentManagement.ConsentService.AdminService;
import com.springboot.ConsentManagement.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public Doctor addDoctor(@RequestBody Doctor doctor) throws IllegalAccessException {
        return this.AdminServiceHandler.addDoctor(doctor);
    }

    @PostMapping(path="/admin/AddPat")
    public Patient addPatient(@RequestBody Patient patient) throws IllegalAccessException {
        return this.AdminServiceHandler.addPatient(patient);
    }

    @PostMapping(path="/admin/Update-Authorities/{role}/{metaId}")
    public void updateAuthorities(@PathVariable("metaId") String metaId,
                                  @PathVariable("role") String role,
                                  @RequestBody Set<Authority> authorities){

        this.AdminServiceHandler.updateAuthorities(metaId,authorities,role);
    }

    @PreAuthorize("hasPermission(#metaId,'authorities:read')")
    @GetMapping(path="/admin/Get-Authorities/{role}/{metaId}")
    public Set<Authority> getAuthorities(@PathVariable("metaId") String metaId,
                                         @PathVariable("role") String role){

        return this.AdminServiceHandler.getAuthorities(metaId,role);
    }

    @GetMapping(path="/admin/Get-AvailableDoctors")
    public Set<AvailableDoctors> getAvailableDoctors() {
        return this.AdminServiceHandler.getAvailableDoctors();
    }
}
