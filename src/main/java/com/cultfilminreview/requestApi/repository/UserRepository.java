package com.cultfilminreview.requestApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.cultfilminreview.requestApi.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByEmail(String email);

}
