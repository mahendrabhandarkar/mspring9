package com.ks.mspring9.repository;

import com.ks.mspring9.entity.CiSessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CiSessionsRepository extends JpaRepository<CiSessions, String>, JpaSpecificationExecutor<CiSessions> {

}