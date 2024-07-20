package com.ks.mspring9.statemachine.repository;

import org.springframework.stereotype.Repository;

import com.ks.mspring9.statemachine.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, Integer>, JpaSpecificationExecutor<OrderMaster>{
    
}
