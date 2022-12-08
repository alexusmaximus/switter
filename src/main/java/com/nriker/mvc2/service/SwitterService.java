package com.nriker.mvc2.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

	public String findUser(SwitterUser user) {
		// return repository.findUser();
		return "findUser: " + user.getName();
	}

	public List<SwitterUser> findAllUser() {
		return repository.findAllUser();
	}

    public String findPost(SwitterPost post) {
        // return repository.findPost();
        return "findPost: " + post.getPostTitle();
    }

	public List<SwitterPost> findAllPosts() {
		return repository.findAllPosts();
	}
}
