package com.nriker.switter.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nriker.switter.model.SwitterLike;
import com.nriker.switter.model.SwitterPost;
import com.nriker.switter.model.SwitterUser;
import com.nriker.switter.service.SwitterLikeService;

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

	public SwitterPost likePost(SwitterPost post, SwitterLike like) {
		post.setLike(like.getID());
		// String postTitle = post.getPostTitle();
		Query query = new Query(Criteria.where("id").is(post.getId()));
		// // Query query = new Query(Criteria.where("id").is(post.getId()));
		// SwitterPost newPost = mongoTemplate.findOne(query, SwitterPost.class);
		// // SwitterPost newPost = findPost(post.getPostTitle());
		return mongoTemplate.findAndReplace(query, post, postsCollection);
	}

	public SwitterPost findPost(String postTitle) {
		Query query = new Query(Criteria.where("postTitle").is(postTitle));
		return mongoTemplate.findOne(query, SwitterPost.class, postsCollection);
	}

	public SwitterPost findPostById(String postId) {
		Query query = new Query(Criteria.where("id").is(postId));
		return mongoTemplate.findOne(query, SwitterPost.class, postsCollection);
	}
	
    public List<SwitterPost> findAllPosts() {
		return mongoTemplate.findAll(SwitterPost.class, postsCollection);
    }

	public SwitterPost deletePost(String postTitle) {
		Query query = new Query(Criteria.where("postTitle").is(postTitle));
		return mongoTemplate.findAndRemove(query, SwitterPost.class, postsCollection);
	}
}
