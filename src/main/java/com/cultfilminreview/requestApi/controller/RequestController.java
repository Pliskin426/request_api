package com.cultfilminreview.requestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cultfilminreview.requestApi.entity.Request;
import com.cultfilminreview.requestApi.service.RequestService;

@RestController
@RequestMapping("users/{userId}/requests")
public class RequestController {
	
	@Autowired
	private RequestService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllRequests() {
		return new ResponseEntity<Object>(service.getAllRequests(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{postId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getRequest(@PathVariable Long requestId) {
		return new ResponseEntity<Object>(service.getRequest(requestId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createRequest(@RequestBody Request request, @PathVariable Long userId) {
		try {
			return new ResponseEntity<Object>(service.createRequest(request, userId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{postId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updatePost(@RequestBody Request request, @PathVariable Long requestId) {
		try {
			return new ResponseEntity<Object>(service.updateRequest(request, requestId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
