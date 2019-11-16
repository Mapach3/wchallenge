package com.gcontento.wchallenge.helpers;

import java.util.ArrayList;
import java.util.List;

import com.gcontento.wchallenge.models.UserModel;

public class UserModelList {
	
	private List<UserModel> userModels;
	
	
	public UserModelList() {
		
		setUserModels(new ArrayList<UserModel>());
	}


	public List<UserModel> getUserModels() {
		return userModels;
	}


	public void setUserModels(List<UserModel> userModels) {
		this.userModels = userModels;
	}
		
	
	
	
	
	
	

}
