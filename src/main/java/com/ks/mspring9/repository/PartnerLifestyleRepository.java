package com.ks.mspring9.repository;

import com.ks.mspring9.entity.PartnerLifestyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PartnerLifestyleRepository extends JpaRepository<PartnerLifestyle, Integer>, JpaSpecificationExecutor<PartnerLifestyle> {

}