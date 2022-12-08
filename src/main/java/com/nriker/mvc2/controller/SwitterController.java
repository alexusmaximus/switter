package com.nriker.mvc2.controller;

// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nriker.mvc2.model.SwitterUser;
import com.nriker.mvc2.model.SwitterPost;

//Todo RestCotroller res.
@RestController
@RequestMapping(SwitterController.BASE_PATH)
public class SwitterController {

	public static final String BASE_PATH = "/api/v1/";

	@GetMapping("/hello")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "Hello, World!";
	}

	@PostMapping("/add/user")
	public String addUser(@RequestBody SwitterUser newUser) {
		return newUser.getName() + ": " + newUser.getPassword();
	}

	@PostMapping("/add/post")
	public String addPost(@RequestBody SwitterPost newPost) {
		return newPost.getUserName() + 
		": " + newPost.getPostTitle() + 
		": " + newPost.getPostMessage() + "\nOk";
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
