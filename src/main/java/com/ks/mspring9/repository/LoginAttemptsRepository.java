package com.ks.mspring9.repository;

import com.ks.mspring9.entity.LoginAttempts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoginAttemptsRepository extends JpaRepository<LoginAttempts, Integer>, JpaSpecificationExecutor<LoginAttempts> {

}