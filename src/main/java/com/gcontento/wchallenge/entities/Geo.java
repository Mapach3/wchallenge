package com.gcontento.wchallenge.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name="geo")
@Entity
public class Geo {
	
	
	@GeneratedValue
	@Id
	@Column(name="idGeo")
	private long id;
	
	@Column(name="lat")
	private String lat;
	
	@Column(name="lng")
	private String lng;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="geo")
	@JoinColumn(name="idAddress", nullable=false)
	private Address address;
	
	
	public Geo() {}


	public Geo(long id, String lat, String lng, Address address) {
		super();
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.address = address;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLat() {
		return lat;
	}


	public void setLat(String lat) {
		this.lat = lat;
	}


	public String getLng() {
		return lng;
	}


	public void setLng(String lng) {
		this.lng = lng;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

}
