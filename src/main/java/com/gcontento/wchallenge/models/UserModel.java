package com.gcontento.wchallenge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
	
		private long id;
		private String name;
		private String username;
		private String email;
		private AddressModel address;
		private String phone;
		private String website;
		private CompanyModel company;
			

		public UserModel() {
			super();
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

		public AddressModel getAddress() {
			return address;
		}

		public void setAddress(AddressModel address) {
			this.address = address;
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

		public CompanyModel getCompany() {
			return company;
		}

		public void setCompany(CompanyModel company) {
			this.company = company;
		}
		
		
		
	
	

}
