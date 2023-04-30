package com.springboot.ConsentManagement.ConsentDatabase.ConsentDao;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.TempTableA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempTableRepoAPI extends JpaRepository<TempTableA,String> {
}
