package com.ks.mspring9.repository;

import com.ks.mspring9.entity.UserLifestyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserLifestyleRepository extends JpaRepository<UserLifestyle, Integer>, JpaSpecificationExecutor<UserLifestyle> {

}