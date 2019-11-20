package com.gcontento.wchallenge.models;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gcontento.wchallenge.entities.Album;
import com.gcontento.wchallenge.entities.PermissionType;
import com.gcontento.wchallenge.entities.User;

public class UserAlbumModel {
	
	private long id;
	
	private PermissionType permissionType;
	
	private User user;
	
	private Album album;

	public UserAlbumModel(long id, PermissionType permissionType, User user, Album album) {
		super();
		this.id = id;
		this.permissionType = permissionType;
		this.user = user;
		this.album = album;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PermissionType getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(PermissionType permissionType) {
		this.permissionType = permissionType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
	
	
	

}
