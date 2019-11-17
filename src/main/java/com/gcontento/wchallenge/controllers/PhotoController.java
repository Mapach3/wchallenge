package com.gcontento.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gcontento.wchallenge.helpers.ConstantHelper;
import com.gcontento.wchallenge.models.AlbumExternalModel;
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
	
	
	/** GET request to fetch all photos from an user given by parameter */
	@GetMapping("/photosFiltered")
	public List<PhotoModel[]> getPhotoByUserId(@PathParam("userId") long userId) {
		RestTemplate restTemplate = new RestTemplate();
		AlbumExternalModel[] albums = {};
		List<PhotoModel[]> photos = new ArrayList<PhotoModel[]>();
		//first request: get all albums that have the given userId.
		ResponseEntity<AlbumExternalModel[]> responseAlbums = restTemplate.getForEntity(ConstantHelper.ALBUMS_API_URL+"?userId="+userId, AlbumExternalModel[].class);
		albums = responseAlbums.getBody();
		//second request: take each album and fetch all photos, since api allows for nested resource search.
		for (AlbumExternalModel album : albums){
			ResponseEntity<PhotoModel[]> responsePhoto = restTemplate.getForEntity(ConstantHelper.PHOTOS_API_URL+"?albumId="+album.getId(),PhotoModel[].class);
			photos.add(responsePhoto.getBody());
		}
		
		return photos;
		
		
		
		
		
	}
	

}
