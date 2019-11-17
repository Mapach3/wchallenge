package com.gcontento.wchallenge.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name="company")
@Entity
public class Company {
	
	@GeneratedValue
	@Id
	@Column(name="idCompany")
	private long id;
		
	@Column(name="name")
	private String name;
	
	@Column(name="catchphrase")
	private String catchphrase;
	
	@Column(name="bs")
	private String bs;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy="company")
	private User user;

	public Company() {
		super();
	}

	public Company(long id, String name, String catchphrase, String bs, User user) {
		super();
		this.id = id;
		this.name = name;
		this.catchphrase = catchphrase;
		this.bs = bs;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchphrase() {
		return catchphrase;
	}

	public void setCatchphrase(String catchphrase) {
		this.catchphrase = catchphrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
