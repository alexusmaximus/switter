package com.nriker.mvc2.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.nriker.mvc2.model.SwitterPost;
import com.nriker.mvc2.model.SwitterUser;
import org.springframework.beans.factory.annotation.Value;

@Repository
public class SwitterMongoDBRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Value("${spring.data.mongodb.database.collection.users}")
    private String usersCollection;

	@Value("${spring.data.mongodb.database.collection.posts}")
    private String postsCollection;

	public SwitterUser addUser(SwitterUser newUser) {
		return mongoTemplate.insert(newUser, usersCollection);
	}

	public List<SwitterUser> findAllUser() {
        return mongoTemplate.findAll(SwitterUser.class, usersCollection);
	}

    public List<SwitterPost> findAllPosts() {
        return mongoTemplate.findAll(SwitterPost.class, postsCollection);
    }
}