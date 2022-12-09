package com.nriker.mvc2.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.DeleteResult;
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

	public SwitterUser addUser(SwitterUser user) {
		if (findUser(user.getName()) == null) {
			return mongoTemplate.insert(user, usersCollection);
		} else {
			System.out.println("Der User schon existiert!");
			return null;
		}
	}

	public SwitterPost addPost(SwitterPost post) {
		if (findPost(post.getPostTitle()) == null) {
			return mongoTemplate.insert(post, postsCollection);
		} else {
			System.out.println("Das Post schon existiert!");
			return null;
		}
	}

	public SwitterUser findUser(String userName) {
		Query query = new Query(Criteria.where("name").is(userName));
		return mongoTemplate.findOne(query, SwitterUser.class, usersCollection);
	}

	public SwitterPost findPost(String postTitle) {
		Query query = new Query(Criteria.where("postTitle").is(postTitle));
		return mongoTemplate.findOne(query, SwitterPost.class, postsCollection);
	}

	public List<SwitterUser> findAllUser() {
		return mongoTemplate.findAll(SwitterUser.class, usersCollection);
	}
	
    public List<SwitterPost> findAllPosts() {
		return mongoTemplate.findAll(SwitterPost.class, postsCollection);
    }

	public SwitterUser deleteUser(String userName) {
		Query query = new Query(Criteria.where("name").is(userName));
		// return mongoTemplate.remove(query, SwitterUser.class, usersCollection);
		return mongoTemplate.findAndRemove(query, SwitterUser.class, usersCollection);
	}

	public SwitterPost deletePost(String postTitle) {
		Query query = new Query(Criteria.where("postTitle").is(postTitle));
		// return mongoTemplate.remove(query, SwitterUser.class, usersCollection);
		return mongoTemplate.findAndRemove(query, SwitterPost.class, postsCollection);
	}
}
