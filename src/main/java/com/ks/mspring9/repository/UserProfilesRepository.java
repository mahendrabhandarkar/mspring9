package com.ks.mspring9.repository;

import com.ks.mspring9.entity.UserProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserProfilesRepository extends JpaRepository<UserProfiles, Integer>, JpaSpecificationExecutor<UserProfiles> {

}