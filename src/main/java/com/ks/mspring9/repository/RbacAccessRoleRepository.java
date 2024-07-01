package com.ks.mspring9.repository;

import com.ks.mspring9.entity.RbacAccessRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RbacAccessRoleRepository extends JpaRepository<RbacAccessRole, Long>, JpaSpecificationExecutor<RbacAccessRole> {
}
