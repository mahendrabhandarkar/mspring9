package com.ks.mspring9.repository;

import com.ks.mspring9.entity.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StatesRepository extends JpaRepository<States, Integer>, JpaSpecificationExecutor<States> {

}