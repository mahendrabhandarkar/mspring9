package com.ks.mspring9.statemachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ks.mspring9.statemachine.entity.SttQueueStateTransitionMaster;

@Repository
public interface SttQueueStateTransitionMasterRepository extends JpaRepository<SttQueueStateTransitionMaster, Integer>, JpaSpecificationExecutor<SttQueueStateTransitionMaster>{
    
}
