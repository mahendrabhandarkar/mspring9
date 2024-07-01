package com.ks.mspring9.repository;

import com.ks.mspring9.entity.Height;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HeightRepository extends JpaRepository<Height, Integer>, JpaSpecificationExecutor<Height> {

}