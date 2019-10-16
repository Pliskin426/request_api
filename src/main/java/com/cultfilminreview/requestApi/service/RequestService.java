package com.cultfilminreview.requestApi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cultfilminreview.requestApi.entity.Request;
import com.cultfilminreview.requestApi.entity.User;
import com.cultfilminreview.requestApi.repository.RequestRepository;
import com.cultfilminreview.requestApi.repository.UserRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Iterable<Request> getAllRequests() {
		return repo.findAll();
	}
	
	public Request getRequest(Long id) {
		return repo.findOne(id);
	}
	
	public Request updateRequest(Request request, Long id) throws Exception {
		Request foundRequest = repo.findOne(id);
		if (foundRequest == null) {
			throw new Exception("Request not found.");
		}
		foundRequest.setDescription(request.getDescription());
		return repo.save(foundRequest);
	}
	
	public Request createRequest(Request request, Long userId) throws Exception {
		User user = userRepo.findOne(userId);
		if (user == null) {
			throw new Exception("User not found.");
		}
		request.setDate(new Date());
		request.setUser(user);
		return repo.save(request);
	}
	
	public void deleteRequest(Request request, Long id) {
		repo.delete(id);
	}
}
