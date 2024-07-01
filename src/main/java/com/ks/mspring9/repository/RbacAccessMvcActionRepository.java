package com.ks.mspring9.repository;

import com.ks.mspring9.entity.RbacAccessMvcAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RbacAccessMvcActionRepository extends JpaRepository<RbacAccessMvcAction, Long>, JpaSpecificationExecutor<RbacAccessMvcAction> {

}
