package com.nriker.mvc2.controller;

// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.nriker.mvc2.model.SwitterUser;
import com.nriker.mvc2.service.SwitterService;
import com.nriker.mvc2.model.SwitterPost;

//Todo RestCotroller res.
@RestController
@RequestMapping(SwitterController.BASE_PATH)
public class SwitterController {

	@Autowired
	private SwitterService switterService;

	public static final String BASE_PATH = "/api/v1/";

	@GetMapping("/hello")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "Hello, World!";
	}

	@PostMapping("/add/user")
	public SwitterUser addUser(@RequestBody SwitterUser user) {
		return switterService.addUser(user);
	}

	@PostMapping("/add/post")
	public String addPost(@RequestBody SwitterPost newPost) {
		return newPost.getUserName() + 
		": " + newPost.getPostTitle() + 
		": " + newPost.getPostMessage() + "\nOk";
	}

	@PostMapping("/find/user")
	public String findUser(@RequestBody SwitterUser user) {
		return switterService.findUser(user);
	}

	@GetMapping("/find/all/users")
	public List<SwitterUser> findAllUser() {
		return switterService.findAllUser();
	}

	@PostMapping("/find/post")
	public String findPost(@RequestBody SwitterPost post) {
		return switterService.findPost(post);
	}

	@GetMapping("/find/all/posts")
	public List<SwitterPost> findAllPosts() {
		return switterService.findAllPosts();
	}

	// @PostMapping("/change/user")
	// public String changeUser(@RequestBody SwitterUser newUser) {
	// 	return newUser.getName() + ": " + newUser.getPassword();
	// }

	// @PostMapping("/change/post")
	// public String changePost(@RequestBody SwitterUser newUser) {
	// 	return newUser.getName() + ": " + newUser.getPassword();
	// }

	// @PostMapping("/delete/user")
	// public String deleteUser(@RequestBody SwitterUser newUser) {
	// 	return newUser.getName() + ": " + newUser.getPassword();
	// }

	// @PostMapping("/delete/post")
	// public String deletePost(@RequestBody SwitterUser newUser) {
	// 	return newUser.getName() + ": " + newUser.getPassword();
	// }
}
