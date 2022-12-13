package com.nriker.switter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.nriker.switter.service.SwitterLikeService;
import com.nriker.switter.model.SwitterLike;
import com.nriker.switter.model.SwitterUser;

//Todo RestCotroller res.
@RestController
@RequestMapping(SwitterLikeController.BASE_PATH)
public class SwitterLikeController {

	@Autowired
	private SwitterLikeService switterService;

	public static final String BASE_PATH = "/api/v1/like";
	
	//Todo if false?
	@PostMapping
	public ResponseEntity<SwitterLike> addLike(@RequestBody SwitterLike like) {
		SwitterLike createdLike = switterService.addLike(like);
		return ResponseEntity.created(URI.create(BASE_PATH + "/" + createdLike.getID())).build();
	}

	@DeleteMapping("/{likeId}")
	public ResponseEntity<SwitterLike> deleteLike(@PathVariable String likeId) {
		 switterService.deleteLike(likeId);
		 return ResponseEntity.ok().build();
	}

	@GetMapping("/id/{likeId}")
	public ResponseEntity<SwitterLike> findLikeById(@PathVariable String likeId) {
	 SwitterLike foundLike =  switterService.findLikeById(likeId);
	 if(foundLike == null){
		return ResponseEntity.notFound().build();
	 }
	 return ResponseEntity.ok(foundLike);
	}

	@GetMapping("/userId/{userId}")
	public List<SwitterLike> findAllLikesByUserId(@PathVariable String userId) {
		return switterService.findAllLikesByUserId(userId);
	}

	@GetMapping("/likedPost/{postId}")
	public List<SwitterUser> findAllUsersThatLikedPostByPostId(@PathVariable String postId) {
		return switterService.findAllUsersThatLikedPostByPostId(postId);
	}

	@GetMapping("/postId/{postId}")
	public List<SwitterLike> findAllLikesByPostId(@PathVariable String postId) {
		return switterService.findAllLikesByPostId(postId);
	}

	@GetMapping
	public List<SwitterLike> findAllLikes() {
		return switterService.findAllLikes();
	}
}
