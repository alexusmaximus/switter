package com.nriker.switter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@PostMapping
	public SwitterUser addUser(@RequestBody SwitterUser user) {
		return switterService.addUser(user);
	}

	@DeleteMapping("/{name}")
	public SwitterUser deleteUser(@PathVariable String name) {
		return switterService.deleteUser(name);
	}

	@GetMapping("/{name}")
	public SwitterUser findUser(@PathVariable String name) {
		return switterService.findUser(name);
	}

	// @PatchMapping("/{name}")
	// public String changeUser(@PathVariable String name) {
	// 	return switterService.updateUser(name);
	// }

	@GetMapping
	public List<SwitterUser> findAllUser() {
		return switterService.findAllUser();
	}
}
