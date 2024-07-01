package com.ks.mspring9.repository;

import com.ks.mspring9.entity.UserFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserFileRepository extends JpaRepository<UserFile, Integer>, JpaSpecificationExecutor<UserFile> {

}