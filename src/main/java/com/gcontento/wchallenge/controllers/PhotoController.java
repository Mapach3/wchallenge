package com.gcontento.wchallenge.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gcontento.wchallenge.helpers.ConstantHelper;
import com.gcontento.wchallenge.models.PhotoModel;

@RestController
@RequestMapping("/v1")
public class PhotoController {
	
	
	/**GET request to the external service to fetch all Photos */
	/** Using Array since deserialization of JSON fails when trying to return a List of PhotoModel. */
	@GetMapping("/photos")
	public PhotoModel[] getAllPhotos() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PhotoModel[]> response = restTemplate.getForEntity(ConstantHelper.PHOTOS_API_URL, PhotoModel[].class);
		PhotoModel[] photos = response.getBody();
		return photos;		
	}
	
	
	/**GET request to the external service to fetch a specific Photo */	
	@GetMapping("/photos/{id}")
	public PhotoModel getPhotoById(@PathVariable("id") long id) {
		RestTemplate restTemplate = new RestTemplate();
		PhotoModel photo = restTemplate.getForObject(ConstantHelper.PHOTOS_API_URL+id, PhotoModel.class);
		return photo;
	}
	

}
