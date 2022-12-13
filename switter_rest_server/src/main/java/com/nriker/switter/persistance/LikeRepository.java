package com.nriker.switter.persistance;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nriker.switter.model.SwitterLike;

public interface LikeRepository extends MongoRepository<SwitterLike,String> {
    
}
