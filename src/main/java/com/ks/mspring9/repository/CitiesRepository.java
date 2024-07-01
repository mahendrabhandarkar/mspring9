package com.ks.mspring9.repository;

import com.ks.mspring9.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CitiesRepository extends JpaRepository<Cities, Integer>, JpaSpecificationExecutor<Cities> {

}