package com.gcontento.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gcontento.wchallenge.helpers.ConstantHelper;
import com.gcontento.wchallenge.helpers.UserModelList;
import com.gcontento.wchallenge.models.UserModel;

@RestController
public class UserController {
	
	
	/**GET request to the external service to fetch all Users */
	/** Using Array since deserialization of JSON fails when trying to return a List of UserModel. */	
	@GetMapping("/users")
	public UserModel[] getAllUsers() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserModel[]> response = 	restTemplate.getForEntity(ConstantHelper.USERS_API_URL, UserModel[].class);
		return response.getBody();	
	}
	
	
	
	/**GET request to the external service to fetch a specific User */	
	@GetMapping("/users/{id}")
	public UserModel getUserById(@PathVariable("id") long id) {
		RestTemplate restTemplate = new RestTemplate();
		UserModel user = restTemplate.getForObject(ConstantHelper.USERS_API_URL+id, UserModel.class);
		return user;
		
		
	}
	
	


	
	
	
}