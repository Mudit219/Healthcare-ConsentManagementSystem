package com.springboot.ConsentManagement.Security;

import com.springboot.ConsentManagement.ConsentDao.DoctorRepository;
import com.springboot.ConsentManagement.ConsentDao.PatientRepository;
import com.springboot.ConsentManagement.Entities.Doctor;
import com.springboot.ConsentManagement.Entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class JPAUserDetailsService implements UserDetailsService {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Given a username, if the username exists then fetching all its details from database and making a UserDetails object for that user.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Doctor doc = doctorRepo.findByMetaId(username);
            Patient pat = patientRepo.findByMetaId(username);
            if(doc!=null) {
                return new JPAUserDetails(doc.getMetaId(),
                        passwordEncoder.encode(doc.getPassword()),
                        doc.getAuthorities().stream().map(authority ->
                                new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toSet()),
                        true,
                        true,
                        true,
                        true
                );
            }
            return new JPAUserDetails(pat.getMetaId(),
                    passwordEncoder.encode(pat.getPassword()),
                    pat.getAuthorities().stream().map(authority ->
                            new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toSet()),
                    true,
                    true,
                    true,
                    true
            );

        } catch (UsernameNotFoundException e){
            throw(e);
        }

    }
}
