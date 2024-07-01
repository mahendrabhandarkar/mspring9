package com.ks.mspring9.repository;

import com.ks.mspring9.entity.UserFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserFamilyRepository extends JpaRepository<UserFamily, Integer>, JpaSpecificationExecutor<UserFamily> {

}