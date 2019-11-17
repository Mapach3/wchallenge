package com.gcontento.wchallenge.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="album")
public class Album {
	
	@GeneratedValue
	@Id
	@Column(name="idAlbum")
	private long id;
	
	@Column(name="ownerId")
	private long ownerId;
	
	@Column(name="title")
	private String title;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="album")
	private Set<Photo> photos = new HashSet<Photo>();
	
	public Album() {}

	public Album(long id, long ownerId, String title) {
		super();
		this.id = id;
		this.ownerId = ownerId;
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
