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
	
	@GetMapping("/albums")
	public AlbumExternalModel[] getAllAlbumExternal() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AlbumExternalModel[]> response = restTemplate.getForEntity(ConstantHelper.ALBUMS_API_URL, AlbumExternalModel[].class);
		AlbumExternalModel[] albumExternal = response.getBody();
		return albumExternal;
	}
	
	
	@GetMapping("/albums/{id}")
	public AlbumExternalModel getAllbumExternalById(@PathVariable("id") long id) {
		RestTemplate restTemplate = new RestTemplate();
		AlbumExternalModel albumExternal = restTemplate.getForObject(ConstantHelper.ALBUMS_API_URL+id, AlbumExternalModel.class);
		return albumExternal;
	}
	
	

}
