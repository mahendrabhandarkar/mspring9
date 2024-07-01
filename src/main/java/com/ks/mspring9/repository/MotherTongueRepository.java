package com.ks.mspring9.repository;

import com.ks.mspring9.entity.MotherTongue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MotherTongueRepository extends JpaRepository<MotherTongue, Integer>, JpaSpecificationExecutor<MotherTongue> {

}