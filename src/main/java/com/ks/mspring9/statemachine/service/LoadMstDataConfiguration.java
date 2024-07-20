package com.ks.mspring9.statemachine.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ks.mspring9.statemachine.entity.OrderMaster;
import com.ks.mspring9.statemachine.entity.SttQueueStateTransitionMaster;
import com.ks.mspring9.statemachine.repository.OrderMasterRepository;
import com.ks.mspring9.statemachine.repository.SttQueueStateTransitionMasterRepository;

import jakarta.inject.Singleton;

@Component
@Singleton
public class LoadMstDataConfiguration {

    @Autowired
    public OrderMasterRepository orderMasterRepository;
    public List<OrderMaster> orderMasterList;

    @Autowired
    public SttQueueStateTransitionMasterRepository sttQueueStateTransitionMasterRepository;
    public List<SttQueueStateTransitionMaster> sttQueueStateTransitionMasterList;

    @EventListener(ApplicationReadyEvent.class)
    public void load()
    {
        {
        // request.getNotificationIdList().removeAll(Collections.singleton(null));
        // Collections.unmodifiableList(accessActionRoleEntityRepository.findAll()); 
        // controllerActionsMap = Collections.unmodifiableMap(caMapTemp);
        // AppConstrant.java, AppStatus.java
        // appContext.getBean("")
        orderMasterList = Collections.unmodifiableList(orderMasterRepository.findAll());
        sttQueueStateTransitionMasterList = Collections.unmodifiableList(sttQueueStateTransitionMasterRepository.findAll());
        
        }
    }
}
