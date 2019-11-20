package com.gcontento.wchallenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlbumExternalModel {
	
	private long id;
	
	@JsonProperty("userId")
	private long ownerId;
	private String title;

	public AlbumExternalModel(long id, long ownerId, String title) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		this.title = title;
	}

	public AlbumExternalModel() {
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

}
