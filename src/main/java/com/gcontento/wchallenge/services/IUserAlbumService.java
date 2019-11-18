package com.gcontento.wchallenge.services;

import java.util.List;

import com.gcontento.wchallenge.entities.UserAlbum;
import com.gcontento.wchallenge.models.AlbumExternalModel;
import com.gcontento.wchallenge.models.UserModel;

public interface IUserAlbumService {
	
	public List<UserAlbum> getAll();
	
	
	/*Shares album with User*/
	public boolean insertAlbumUser(AlbumExternalModel album, UserModel user, long permissionTypeId);
	
	public boolean updateUserPermission(AlbumExternalModel album, UserModel user, long permissionTypeId);
	
	public boolean userExists(long userIdApi);
	
	public boolean albumExists(long albumIdApi);
	
	public boolean userAlbumExists(long userId,long albumId);

}
