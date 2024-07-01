package com.ks.mspring9.repository;

import com.ks.mspring9.entity.WorkingAs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WorkingAsRepository extends JpaRepository<WorkingAs, Integer>, JpaSpecificationExecutor<WorkingAs> {

}