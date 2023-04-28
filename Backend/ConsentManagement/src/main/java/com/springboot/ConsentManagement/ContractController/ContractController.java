package com.springboot.ConsentManagement.ContractController;

import kotlin.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ConsentManagement.ContractModel.Contract;
import com.springboot.ConsentManagement.ContractService.ContractService;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    @Qualifier("contractServiceConfiguration")
    ContractService service;

    @GetMapping("/owner")
    public String getOwnerAccount() {
        return service.getOwnerAccount();
    }

    @PostMapping("/AddNewUser")
    public String AddNewuser(String _user,String role) {
        Pair<Boolean, String> res = service.AddNewUserToContract(_user,role);
        return res.getSecond();
    }

    @PostMapping
    public Contract createContract(@RequestBody Contract newContract) throws Exception {
        return service.createContract(newContract);
    }

    @PostMapping("/ReqConns")
    public List RequestedConnections(String _user) throws Exception {
        Pair<Boolean,List> res = service.GetRequestedConnection(_user);
        return res.getSecond();
    }

    @PostMapping("/AcceptConns")
    public List AcceptedConnections(String _user) throws Exception {

        Pair<Boolean,List> res = service.GetAcceptedConnection(_user);
        return res.getSecond();
    }

    @PostMapping("/CheckValidRecords")
    public Boolean RequestedConnections(String _doctor,List<String> records) throws Exception {
        Pair<Boolean,Boolean> res = service.CheckValidRecords(_doctor,records);
        return res.getSecond();
    }

//    @GetMapping("/Notifications")
//    public void Notifications(String _user) throws Exception{
//        service.GetNotifications(_user);
//    }
}