package com.ks.mspring9.repository;

import com.ks.mspring9.entity.UserHobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserHobbiesRepository extends JpaRepository<UserHobbies, Integer>, JpaSpecificationExecutor<UserHobbies> {

}