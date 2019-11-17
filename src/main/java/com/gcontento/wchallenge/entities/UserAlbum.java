package com.gcontento.wchallenge.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name="UserAlbum")
@Entity
public class UserAlbum {
	
	
	@GeneratedValue
	@Id
	@Column(name="idUserAlbum")
	private long id;
	
	@Enumerated(EnumType.STRING)
	private PermissionType permissionType;
	
	@ManyToOne
	@JoinColumn(name="idUser",nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="idAlbum",nullable=false)
	private Album album;

	public UserAlbum() {
		super();
	}

	public UserAlbum(long id, PermissionType permissionType, User user, Album album) {
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
