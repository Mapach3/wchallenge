package com.gcontento.wchallenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostModel {
	private long id;
	@JsonProperty("userId")
	private long idUser;
	private String title;
	private String body;
	
	public PostModel(){}

	public PostModel(long id, long idUser, String title, String body) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.title = title;
		this.body = body;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	
	
	

}
