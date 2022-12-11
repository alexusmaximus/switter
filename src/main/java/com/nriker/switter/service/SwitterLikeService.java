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
	private SwitterPostService switterPostService;
	@Autowired
	private SwitterUserService switterUserService;
	@Autowired
    private SwitterLikeRepository likesRepository;
	
	public SwitterLike addLike(SwitterLike like) {
		if (switterUserService.findUserById(like.getUserId()) == null) {
			System.out.println("Der User nicht existiert!");
			return null;
		}
		SwitterPost switterPost = switterPostService.findPostById(like.getPostId());
		if (switterPost == null) {
			System.out.println("Das Post nicht existiert!");
			return null;
		}
		SwitterLike newLike = likesRepository.addLike(like);
		if (newLike != null) {
			switterPost.setLike(newLike.getID());
		}
		return newLike;
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

	public List<SwitterLike> findAllLikes() {
		return likesRepository.findAllLikes();
	}
}
