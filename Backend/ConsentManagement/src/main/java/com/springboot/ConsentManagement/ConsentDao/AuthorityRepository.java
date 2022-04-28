package com.springboot.ConsentManagement.ConsentDao;

import com.springboot.ConsentManagement.Entities.Authority;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    public Authority findByAuthority(String authority);
}
