package com.ks.mspring9.repository;

import com.ks.mspring9.entity.Religion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReligionRepository extends JpaRepository<Religion, Integer>, JpaSpecificationExecutor<Religion> {

}