package com.gcontento.wchallenge.converters;

import org.springframework.stereotype.Component;

import com.gcontento.wchallenge.entities.User;
import com.gcontento.wchallenge.models.UserModel;


@Component("userConverter")
public class UserConverter {
	
//	public UserModel entityToModel(User user) {
//
//	}

	public User modelToEntity(UserModel userModel) {
		return new User(userModel.getId(), userModel.getName(), userModel.getUsername(), userModel.getEmail(), userModel.getPhone(), userModel.getWebsite());
	}

}
