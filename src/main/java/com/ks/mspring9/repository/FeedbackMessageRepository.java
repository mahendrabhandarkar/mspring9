package com.ks.mspring9.repository;

import com.ks.mspring9.entity.FeedbackMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FeedbackMessageRepository extends JpaRepository<FeedbackMessage, Integer>, JpaSpecificationExecutor<FeedbackMessage> {

}