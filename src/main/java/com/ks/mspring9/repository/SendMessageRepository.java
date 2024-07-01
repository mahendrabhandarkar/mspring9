package com.ks.mspring9.repository;

import com.ks.mspring9.entity.SendMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SendMessageRepository extends JpaRepository<SendMessage, Integer>, JpaSpecificationExecutor<SendMessage> {

}