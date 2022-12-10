package com.nriker.switter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nriker.switter.model.SwitterPost;
import com.nriker.switter.persistance.SwitterPostRepository;

import org.springframework.beans.factory.annotation.Autowired;

//Todo Service res.
@Service
public class SwitterPostService {

	@Autowired
    private SwitterPostRepository postsRepository;
	
	public SwitterPost addPost(SwitterPost post) {
		return postsRepository.addPost(post);
	}

	public SwitterPost deletePost(String userPost) {
		return postsRepository.deletePost(userPost);
	}

	public SwitterPost findPost(String postTitle) {
		return postsRepository.findPost(postTitle);
	}

	public List<SwitterPost> findAllPosts() {
		return postsRepository.findAllPosts();
	}
}
