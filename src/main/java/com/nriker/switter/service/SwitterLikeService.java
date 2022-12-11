package com.nriker.switter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nriker.switter.model.SwitterLike;
import com.nriker.switter.model.SwitterPost;
import com.nriker.switter.persistance.SwitterLikeRepository;
import com.nriker.switter.persistance.SwitterPostRepository;

import org.springframework.beans.factory.annotation.Autowired;

//Todo Service res.
@Service
public class SwitterLikeService {

	@Autowired
    private SwitterLikeRepository likesRepository;
	
	public SwitterLike addLike(SwitterLike like) {
		return likesRepository.addLike(like);
	}

	public SwitterLike deleteLike(String likeId) {
		return likesRepository.deleteLike(likeId);
	}

	public SwitterLike findLikeById(String likeId) {
		return likesRepository.findLikeById(likeId);
	}

	public List<SwitterLike> findAllLikesByUserId(String userId) {
		return likesRepository.findAllLikesByUserId(userId);
	}

	public List<SwitterLike> findAllLikesByPostId(String postId) {
		return likesRepository.findAllLikesByPostId(postId);
	}

	// public SwitterPost findPostById(String postId) {
	// 	return postsRepository.findPostById(postId);
	// }

	// public List<SwitterPost> findAllPosts() {
	// 	return postsRepository.findAllPosts();
	// }
}
