package com.nriker.mvc2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mongodb.client.result.DeleteResult;
import com.nriker.mvc2.model.SwitterPost;
import com.nriker.mvc2.model.SwitterUser;
import com.nriker.mvc2.persistance.SwitterMongoDBRepository;

import org.springframework.beans.factory.annotation.Autowired;

//Todo Service res.
@Service
public class SwitterService {

    @Autowired
    private SwitterMongoDBRepository repository;
	
	public SwitterUser addUser(SwitterUser user) {
		return repository.addUser(user);
	}

	public SwitterPost addPost(SwitterPost post) {
		return repository.addPost(post);
	}

	public SwitterUser deleteUser(String userName) {
		return repository.deleteUser(userName);
	}

	public SwitterPost deletePost(String userPost) {
		return repository.deletePost(userPost);
	}

	public SwitterUser findUser(String userName) {
		return repository.findUser(userName);
	}

	public List<SwitterUser> findAllUser() {
		return repository.findAllUser();
	}

    public SwitterPost findPost(String postTitle) {
        return repository.findPost(postTitle);
    }

	public List<SwitterPost> findAllPosts() {
		return repository.findAllPosts();
	}
}
