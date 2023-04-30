package com.springboot.ConsentManagement.ConsentDatabase.ConsentDao;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.TempTableC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempTableCRepoAPI extends JpaRepository<TempTableC,String> {
}
