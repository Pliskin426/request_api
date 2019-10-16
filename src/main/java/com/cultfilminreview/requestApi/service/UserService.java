package com.cultfilminreview.requestApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cultfilminreview.requestApi.entity.User;
import com.cultfilminreview.requestApi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User createUser(User user) {
		return repo.save(user);
	}
	
	public User login(User user) throws Exception {
		User foundUser = repo.findByEmail(user.getEmail());
		if (foundUser != null && foundUser.getPassword().contentEquals(user.getPassword())) {
			return foundUser;
		} else {
			throw new Exception("Invalid email or password.");
		}
	}
}
