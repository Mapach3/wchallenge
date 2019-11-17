package com.gcontento.wchallenge.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name="address")
@Entity
public class Address {
	
	
	@GeneratedValue
	@Id
	@Column(name="idCompany")
	private long id;
	
	@Column(name="street")
	private String street;
	
	@Column(name="suite")
	private String suite;
	
	@Column(name="citye")
	private String city;
	
	@Column(name="zipcode")
	private String zipcode;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idGeo", nullable=false)
	private Geo geo;

	@OneToOne(fetch = FetchType.LAZY,mappedBy="address")
	private User user;

	public Address() {
		super();
	}

	public Address(long id, String street, String suite, String city, String zipcode, Geo geo) {
		super();
		this.id = id;
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipcode = zipcode;
		this.geo = geo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}
	
	
	

}
