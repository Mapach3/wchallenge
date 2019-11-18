package com.gcontento.wchallenge.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name="user")
@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUser")
	private long id;
	
	@Column(name="apiUserId")
	private long idUserApi;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="website")
	private String website;
	
	public User() {}
	
	

	public User(long idUserApi, String name, String username, String email, String phone, String website) {
		super();
		this.idUserApi = idUserApi;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.website = website;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getIdUserApi() {
		return idUserApi;
	}



	public void setIdUserApi(long idUserApi) {
		this.idUserApi = idUserApi;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}
	
	
	
	



	
	

}
