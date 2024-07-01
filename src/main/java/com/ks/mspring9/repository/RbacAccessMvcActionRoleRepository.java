package com.ks.mspring9.repository;

import com.ks.mspring9.entity.RbacAccessMvcActionRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RbacAccessMvcActionRoleRepository extends JpaRepository<RbacAccessMvcActionRole, Long>, JpaSpecificationExecutor<RbacAccessMvcActionRole> {
}
