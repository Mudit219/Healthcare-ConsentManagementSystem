package com.springboot.ConsentManagement.ConsentDatabase.ConsentDao;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepositoryAPI extends JpaRepository<Authority,Long> {
    public Authority findByAuthority(String authority);
}
