package com.nriker.switter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nriker.switter.service.SwitterLikeService;
import com.nriker.switter.model.SwitterLike;

//Todo RestCotroller res.
@RestController
@RequestMapping(SwitterLikeController.BASE_PATH)
public class SwitterLikeController {

	@Autowired
	private SwitterLikeService switterService;

	public static final String BASE_PATH = "/api/v1/like";
	
	//Todo if false?
	@PostMapping
	public SwitterLike addLike(@RequestBody SwitterLike like) {
		return switterService.addLike(like);
	}

	@DeleteMapping("/{likeId}")
	public SwitterLike deleteLike(@PathVariable String likeId) {
		return switterService.deleteLike(likeId);
	}

	@GetMapping("/id/{likeId}")
	public SwitterLike findLikeById(@PathVariable String likeId) {
		return switterService.findLikeById(likeId);
	}

	@GetMapping("/userId/{userId}")
	public List<SwitterLike> findAllLikesByUserId(@PathVariable String userId) {
		return switterService.findAllLikesByUserId(userId);
	}

	@GetMapping("/postId/{postId}")
	public List<SwitterLike> findAllLikesByPostId(@PathVariable String postId) {
		return switterService.findAllLikesByPostId(postId);
	}

	// @PostMapping("/change/post")
	// public String changePost(@RequestBody SwitterUser newUser) {
	// 	return newUser.getName() + ": " + newUser.getPassword();
	// }

	// @GetMapping
	// public List<SwitterPost> findAllPosts() {
	// 	return switterService.findAllPosts();
	// }
}
