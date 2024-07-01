package com.ks.mspring9.repository;

import com.ks.mspring9.entity.MessageInbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MessageInboxRepository extends JpaRepository<MessageInbox, Integer>, JpaSpecificationExecutor<MessageInbox> {

}