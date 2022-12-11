package com.nriker.switter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.nriker.switter.service.SwitterPostService;
import com.nriker.switter.model.SwitterLike;
import com.nriker.switter.model.SwitterPost;

//Todo RestCotroller res.
@RestController
@RequestMapping(SwitterPostController.BASE_PATH)
public class SwitterPostController {

	@Autowired
	private SwitterPostService switterService;

	public static final String BASE_PATH = "/api/v1/post";
	
	//Todo if false?
	@PostMapping
	public SwitterPost addPost(@RequestBody SwitterPost post) {
		return switterService.addPost(post);
	}

	@DeleteMapping("/{postTitle}")
	public SwitterPost deletePost(@PathVariable String postTitle) {
		return switterService.deletePost(postTitle);
	}

	@GetMapping("/{postTitle}")
	public SwitterPost findPost(@PathVariable String postTitle) {
		return switterService.findPost(postTitle);
	}

	@GetMapping("/id/{postId}")
	public SwitterPost findPostById(@PathVariable String postId) {
		return switterService.findPostById(postId);
	}

	// @PostMapping("/change/post")
	// public String changePost(@RequestBody SwitterUser newUser) {
	// 	return newUser.getName() + ": " + newUser.getPassword();
	// }

	@GetMapping
	public List<SwitterPost> findAllPosts() {
		return switterService.findAllPosts();
	}
}
