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
import org.springframework.beans.factory.annotation.Value;

@Repository
public class SwitterLikeRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

	@Value("${spring.data.mongodb.database.collection.likes}")
    private String likesCollection;

	public SwitterLike addLike(SwitterLike like) {
		Query query = new Query(Criteria
		.where("userId").is(like.getUserId())
		.and("postId").is(like.getPostId()));
		if (mongoTemplate.findOne(query, SwitterLike.class, likesCollection) == null) {
			return mongoTemplate.insert(like, likesCollection);
		} else {
			System.out.println("Der User hat schon das Post geliked!");
			return null;
		}
	}

	public SwitterLike findLikeById(String likeId) {
		Query query = new Query(Criteria.where("id").is(likeId));
		return mongoTemplate.findOne(query, SwitterLike.class, likesCollection);
	}

	// public SwitterPost addPost(SwitterPost post) {
	// 	if (findPost(post.getPostTitle()) == null) {
	// 		return mongoTemplate.insert(post, postsCollection);
	// 	} else {
	// 		System.out.println("Das Post schon existiert!");
	// 		return null;
	// 	}
	// }
	
    public List<SwitterLike> findAllLikesByUserId(String userId) {
		Query query = new Query(Criteria.where("userId").is(userId));
		return mongoTemplate.find(query, SwitterLike.class, likesCollection);
    }

	public List<SwitterLike> findAllLikesByPostId(String postId) {
		Query query = new Query(Criteria.where("postId").is(postId));
		return mongoTemplate.find(query, SwitterLike.class, likesCollection);
    }

	// public SwitterPost deletePost(String postTitle) {
	// 	Query query = new Query(Criteria.where("postTitle").is(postTitle));
	// 	return mongoTemplate.findAndRemove(query, SwitterPost.class, postsCollection);
	// }

	// public SwitterLike likePost(SwitterLike like) {
	// 	Query query = new Query(Criteria.where("id").is(like.getPostId()));
	// 	SwitterPost post = findPostById(like.getPostId());
		
	// }
}
