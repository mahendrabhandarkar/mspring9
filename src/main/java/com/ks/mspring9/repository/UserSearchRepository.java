package com.ks.mspring9.repository;

import com.ks.mspring9.entity.UserSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserSearchRepository extends JpaRepository<UserSearch, Integer>, JpaSpecificationExecutor<UserSearch> {

}