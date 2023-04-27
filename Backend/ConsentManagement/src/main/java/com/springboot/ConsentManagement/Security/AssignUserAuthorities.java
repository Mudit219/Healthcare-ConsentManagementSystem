package com.springboot.ConsentManagement.Security;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentDao.AuthorityRepositoryAPI;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Set;
import java.util.stream.Collectors;

// For a given user role/authority it returns the set of authorities which will be used while creating user for first time.
@Configuration
public class AssignUserAuthorities {

    @Autowired
    private AuthorityRepositoryAPI authorityRepo;

    public Set<Authority> getGrantedAuthorities(ConsentUserRole role){
		Set<Authority> authorities = role.getPermissions()
				.stream()
				.map(permission ->
						this.authorityRepo.findByAuthority(permission.getPermission())).collect(Collectors.toSet());

        authorities.add(this.authorityRepo.findByAuthority("ROLE_"+role.name()));
        return authorities;
    }
}
