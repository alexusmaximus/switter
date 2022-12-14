package com.nriker.switter.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nriker.switter.model.SwitterPost;
import com.nriker.switter.model.SwitterUser;
import org.springframework.beans.factory.annotation.Value;

@Repository
public class SwitterPostRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

	@Value("${spring.data.mongodb.database.collection.posts}")
    private String postsCollection;

	public SwitterPost addPost(SwitterPost post) {
		if (findPost(post.getPostTitle()) == null) {
			return mongoTemplate.insert(post, postsCollection);
		} else {
			System.out.println("Das Post schon existiert!");
			return null;
		}
	}

	public SwitterPost findPost(String postTitle) {
		Query query = new Query(Criteria.where("postTitle").is(postTitle));
		return mongoTemplate.findOne(query, SwitterPost.class, postsCollection);
	}
	
    public List<SwitterPost> findAllPosts() {
		return mongoTemplate.findAll(SwitterPost.class, postsCollection);
    }

	public SwitterPost deletePost(String postTitle) {
		Query query = new Query(Criteria.where("postTitle").is(postTitle));
		// return mongoTemplate.remove(query, SwitterUser.class, usersCollection);
		return mongoTemplate.findAndRemove(query, SwitterPost.class, postsCollection);
	}
}
