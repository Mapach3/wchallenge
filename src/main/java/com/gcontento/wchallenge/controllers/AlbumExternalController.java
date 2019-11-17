package com.gcontento.wchallenge.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gcontento.wchallenge.helpers.ConstantHelper;
import com.gcontento.wchallenge.models.AlbumExternalModel;

@RestController
@RequestMapping("/v1")
public class AlbumExternalController {
	
	/**GET request to the external service to fetch all Albums */
	/** Using Array since deserialization of JSON fails when trying to return a List of UserModel. */
	@GetMapping("/albums")
	public AlbumExternalModel[] getAllAlbumExternal() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AlbumExternalModel[]> response = restTemplate.getForEntity(ConstantHelper.ALBUMS_API_URL, AlbumExternalModel[].class);
		AlbumExternalModel[] albumExternal = response.getBody();
		return albumExternal;
	}
	
	/**GET request to the external service to fetch a specific Album*/	
	@GetMapping("/albums/{id}")
	public AlbumExternalModel getAllbumExternalById(@PathVariable("id") long id) {
		RestTemplate restTemplate = new RestTemplate();
		AlbumExternalModel albumExternal = restTemplate.getForObject(ConstantHelper.ALBUMS_API_URL+id, AlbumExternalModel.class);
		return albumExternal;
	}
	
	

}
