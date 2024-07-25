package com.ks.mspring9.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ks.mspring9.entity.DocumentDetails;

@Repository
public interface DocumentDetailsRepository extends MongoRepository<DocumentDetails, Long> {
    
}
