package com.nriker.mvc2.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.nriker.mvc2.model.SwitterUser;

@Repository
public class SwitterMongoDBRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

	public List<SwitterUser> findAllUser() {
        return mongoTemplate.findAll(SwitterUser.class, "users");
	}
}
