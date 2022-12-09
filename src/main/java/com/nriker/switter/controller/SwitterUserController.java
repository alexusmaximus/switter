package com.nriker.switter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.nriker.switter.model.SwitterUser;
import com.nriker.switter.service.SwitterService;

//Todo RestCotroller res.
@RestController
@RequestMapping(SwitterUserController.BASE_PATH)
public class SwitterUserController {

	@Autowired
	private SwitterService switterService;

	public static final String BASE_PATH = "/api/v1/user";

	@PostMapping("/add")
	public SwitterUser addUser(@RequestBody SwitterUser user) {
		return switterService.addUser(user);
	}

	@PostMapping("/delete")
	public SwitterUser deleteUser(@RequestBody SwitterUser user) {
		return switterService.deleteUser(user.getName());
	}

	@PostMapping("/find")
	public SwitterUser findUser(@RequestBody SwitterUser user) {
		return switterService.findUser(user.getName());
	}

	@GetMapping("/find/all")
	public List<SwitterUser> findAllUser() {
		return switterService.findAllUser();
	}

	// @PostMapping("/change/user")
	// public String changeUser(@RequestBody SwitterUser newUser) {
	// 	return newUser.getName() + ": " + newUser.getPassword();
	// }
}
