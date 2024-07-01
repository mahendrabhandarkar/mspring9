package com.ks.mspring9.repository;

import com.ks.mspring9.entity.EducationField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EducationFieldRepository extends JpaRepository<EducationField, Integer>, JpaSpecificationExecutor<EducationField> {

}