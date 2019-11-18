package com.gcontento.wchallenge.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gcontento.wchallenge.helpers.ConstantHelper;
import com.gcontento.wchallenge.models.AlbumExternalModel;
import com.gcontento.wchallenge.models.UserModel;
import com.gcontento.wchallenge.services.implementation.UserAlbumService;

@RestController
@RequestMapping("/v1")
public class UserAlbumController {
	
	@Autowired
	@Qualifier("userAlbumService")
	UserAlbumService userAlbumService;
	
	
	
	/*PUT Request to assign an album to an user (insert in userAlbum table)*/
	/*Request returns true if saved, false otherwise.*/
	@PutMapping("/addUserAlbum")
	public boolean addUserAlbum(@PathParam("userId") long userId,@PathParam("albumId") long albumId,@PathParam("permissionTypeId") long permissionTypeId) {
		RestTemplate restTemplate = new RestTemplate();
		UserModel user = restTemplate.getForObject(ConstantHelper.USERS_API_URL+userId, UserModel.class);
		AlbumExternalModel album = restTemplate.getForObject(ConstantHelper.ALBUMS_API_URL+albumId, AlbumExternalModel.class);
		return userAlbumService.insertAlbumUser(album, user, permissionTypeId);
	}
	
	
	/*PUT Request to update the permission of an user in an album*/
	/*Returns true if a change is made, false oterhwise*/
	@PutMapping("/updatePermission")
	public boolean updatePermission(@PathParam("userId") long userId,@PathParam("albumId") long albumId, @PathParam("permissionTypeId") long permissionTypeId) {
		RestTemplate restTemplate = new RestTemplate();
		UserModel user = restTemplate.getForObject(ConstantHelper.USERS_API_URL+userId, UserModel.class);
		AlbumExternalModel album = restTemplate.getForObject(ConstantHelper.ALBUMS_API_URL+albumId, AlbumExternalModel.class);
		return userAlbumService.updateUserPermission(album, user, permissionTypeId);
	}
	
	

}
