package com.ks.mspring9.repository;

import com.ks.mspring9.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CountriesRepository extends JpaRepository<Countries, Integer>, JpaSpecificationExecutor<Countries> {

}