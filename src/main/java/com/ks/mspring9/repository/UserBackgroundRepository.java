package com.ks.mspring9.repository;

import com.ks.mspring9.entity.UserBackground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserBackgroundRepository extends JpaRepository<UserBackground, Integer>, JpaSpecificationExecutor<UserBackground> {

}