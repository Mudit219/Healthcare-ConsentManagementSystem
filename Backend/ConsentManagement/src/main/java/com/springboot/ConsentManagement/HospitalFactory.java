package com.springboot.ConsentManagement;

import com.springboot.ConsentManagement.ConsentService.HospitalService;
import com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisService;
import com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryService;
import com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HospitalFactory {

    @Autowired
    @Qualifier("FortisService")
    private FortisService fortisService;

    @Autowired
    @Qualifier("NarayanaService")
    private NarayanaService narayanaService;

    @Autowired
    @Qualifier("KaveryService")
    private KaveryService kaveryService;

    public HospitalService getHospital(String name){
        if(name.equals("Fortis")){
            return fortisService;
        }
        else if(name.equals("Narayana")){
            return narayanaService;
        }
        else if(name.equals("Kavery")){
            return kaveryService;
        }
        else return null;
    }
}
