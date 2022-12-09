package com.nriker.switter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mongodb.client.result.DeleteResult;
import com.nriker.switter.model.SwitterPost;
import com.nriker.switter.model.SwitterUser;
import com.nriker.switter.persistance.SwitterUserRepository;
import com.nriker.switter.persistance.SwitterPostRepository;

import org.springframework.beans.factory.annotation.Autowired;

//Todo Service res.
@Service
public class SwitterService {

    @Autowired
    private SwitterUserRepository usersRepository;

	@Autowired
    private SwitterPostRepository postsRepository;
	
	public SwitterUser addUser(SwitterUser user) {
		return usersRepository.addUser(user);
	}

	public SwitterPost addPost(SwitterPost post) {
		return postsRepository.addPost(post);
	}

	public SwitterUser deleteUser(String userName) {
		return usersRepository.deleteUser(userName);
	}

	public SwitterPost deletePost(String userPost) {
		return postsRepository.deletePost(userPost);
	}

	public SwitterUser findUser(String userName) {
		return usersRepository.findUser(userName);
	}

	public SwitterPost findPost(String postTitle) {
		return postsRepository.findPost(postTitle);
	}

	public List<SwitterUser> findAllUser() {
		return usersRepository.findAllUser();
	}

	public List<SwitterPost> findAllPosts() {
		return postsRepository.findAllPosts();
	}
}
