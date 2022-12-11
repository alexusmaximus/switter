package com.nriker.switter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nriker.switter.model.SwitterUser;
import com.nriker.switter.persistance.SwitterUserRepository;

import org.springframework.beans.factory.annotation.Autowired;

//Todo Service res.
@Service
public class SwitterUserService {

    @Autowired
    private SwitterUserRepository usersRepository;

	public SwitterUser addUser(SwitterUser user) {
		return usersRepository.addUser(user);
	}

	public SwitterUser updateUser(SwitterUser user) {
		return usersRepository.updateUser(user);
	}

	public SwitterUser deleteUser(String userName) {
		return usersRepository.deleteUser(userName);
	}

	public SwitterUser findUser(String userName) {
		return usersRepository.findUser(userName);
	}

	public SwitterUser findUserById(String userId) {
		return usersRepository.findUserById(userId);
	}

	public List<SwitterUser> findAllUser() {
		return usersRepository.findAllUser();
	}
}
