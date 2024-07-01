package com.ks.mspring9.repository;

import com.ks.mspring9.entity.UserEdu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserEduRepository extends JpaRepository<UserEdu, Integer>, JpaSpecificationExecutor<UserEdu> {

}