package com.ks.mspring9.repository;

import com.ks.mspring9.entity.WorkingWith;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WorkingWithRepository extends JpaRepository<WorkingWith, Integer>, JpaSpecificationExecutor<WorkingWith> {

}