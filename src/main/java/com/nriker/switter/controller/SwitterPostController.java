package com.nriker.switter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.nriker.switter.service.SwitterService;
import com.nriker.switter.model.SwitterPost;

//Todo RestCotroller res.
@RestController
@RequestMapping(SwitterPostController.BASE_PATH)
public class SwitterPostController {

	@Autowired
	private SwitterService switterService;

	public static final String BASE_PATH = "/api/v1/post/";
	
	//Todo if false?
	@PostMapping("/add")
	public SwitterPost addPost(@RequestBody SwitterPost post) {
		return switterService.addPost(post);
	}

	@PostMapping("/delete")
	public SwitterPost deletePost(@RequestBody SwitterPost post) {
		return switterService.deletePost(post.getPostTitle());
	}

	@PostMapping("/find")
	public SwitterPost findPost(@RequestBody SwitterPost post) {
		return switterService.findPost(post.getPostTitle());
	}

	@GetMapping("/find/all")
	public List<SwitterPost> findAllPosts() {
		return switterService.findAllPosts();
	}

	// @PostMapping("/change/post")
	// public String changePost(@RequestBody SwitterUser newUser) {
	// 	return newUser.getName() + ": " + newUser.getPassword();
	// }
}
