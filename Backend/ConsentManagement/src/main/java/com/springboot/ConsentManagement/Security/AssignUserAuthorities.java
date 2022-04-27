package com.springboot.ConsentManagement.Security;

import com.springboot.ConsentManagement.ConsentDao.AuthorityRepository;
import com.springboot.ConsentManagement.Entities.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// For a given user role/authority it returns the set of authorities which will be used while creating user for first time.
@Configuration
public class AssignUserAuthorities {

    @Autowired
    private AuthorityRepository authorityRepo;

    public Set<Authority> getGrantedAuthorities(ConsentUserRole role){
		Set<Authority> authorities = role.getPermissions()
				.stream()
				.map(permission ->
						this.authorityRepo.findByAuthority(permission.getPermission())).collect(Collectors.toSet());

        authorities.add(this.authorityRepo.findByAuthority("ROLE_"+role.name()));
        return authorities;
    }
}
