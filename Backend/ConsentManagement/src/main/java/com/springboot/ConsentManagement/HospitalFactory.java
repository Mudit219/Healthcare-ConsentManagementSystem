package com.springboot.ConsentManagement;

import com.springboot.ConsentManagement.ConsentService.HospitalService;
import com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisService;
import com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryService;
import com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaService;
import org.springframework.stereotype.Component;

@Component
public class HospitalFactory {
    public HospitalService getHospital(String name){
        if(name.equals("Fortis")){
            return new FortisService();
        }
        else if(name.equals("Narayana")){
            return new NarayanaService();
        }
        else if(name.equals("Kavery")){
            return new KaveryService();
        }
        else return null;
    }
}
