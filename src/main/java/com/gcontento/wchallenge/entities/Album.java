package com.gcontento.wchallenge.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="album")
public class Album {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idAlbum")
	private long id;
	
	@Column(name="ownerId")
	private long ownerId;
	
	@Column(name="apiAlbumId")
	private long idAlbumApi;
	
	@Column(name="title")
	private String title;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="album")
	private Set<Photo> photos = new HashSet<Photo>();

	public Album() {
		super();
	}

	public Album(long ownerId, long idAlbumApi, String title) {
		this.ownerId = ownerId;
		this.idAlbumApi = idAlbumApi;
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public long getIdAlbumApi() {
		return idAlbumApi;
	}

	public void setIdAlbum(long idAlbumApi) {
		this.idAlbumApi = idAlbumApi;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
	
	
	
	
	
	
	
	

}
