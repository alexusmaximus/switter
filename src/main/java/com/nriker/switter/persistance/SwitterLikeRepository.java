package com.nriker.switter.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nriker.switter.model.SwitterLike;
import com.nriker.switter.service.SwitterPostService;
import com.nriker.switter.service.SwitterUserService;

import org.springframework.beans.factory.annotation.Value;

@Repository
public class SwitterLikeRepository {
    @Autowired
	private SwitterPostService switterPostService;
	@Autowired
	private SwitterUserService switterUserService;
	@Autowired
    private MongoTemplate mongoTemplate;

	@Value("${spring.data.mongodb.database.collection.likes}")
    private String likesCollection;

	public SwitterLike addLike(SwitterLike like) {
		if (switterUserService.findUserById(like.getUserId()) == null) {
			System.out.println("Der User nicht existiert!");
			return null;
		}

		if (switterPostService.findPostById(like.getPostId()) == null) {
			System.out.println("Das Post nicht existiert!");
			return null;
		}

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
	
    public List<SwitterLike> findAllLikesByUserId(String userId) {
		Query query = new Query(Criteria.where("userId").is(userId));
		return mongoTemplate.find(query, SwitterLike.class, likesCollection);
    }

	public List<SwitterLike> findAllLikesByPostId(String postId) {
		Query query = new Query(Criteria.where("postId").is(postId));
		return mongoTemplate.find(query, SwitterLike.class, likesCollection);
    }

	public SwitterLike deleteLike(String likeId) {
		Query query = new Query(Criteria.where("id").is(likeId));
		return mongoTemplate.findAndRemove(query, SwitterLike.class, likesCollection);
	}

	// public SwitterLike likePost(SwitterLike like) {
	// 	Query query = new Query(Criteria.where("id").is(like.getPostId()));
	// 	SwitterPost post = findPostById(like.getPostId());
		
	// }
}
