package com.gcontento.wchallenge.models;

public class GeoModel {
	
	private String lat;
	private String lng;
	
	public GeoModel() {}
	
	public GeoModel(String lat, String lng) {
		super();
		this.lat = lat;
		this.lng = lng;
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
	
	
	
	
	
	
	

}
