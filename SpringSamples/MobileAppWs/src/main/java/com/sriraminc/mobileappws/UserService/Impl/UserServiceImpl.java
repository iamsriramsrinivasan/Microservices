package com.sriraminc.mobileappws.UserService.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sriraminc.mobileappws.UserService.UserService;
import com.sriraminc.mobileappws.shared.Utils;
import com.sriraminc.mobileppws.ui.model.request.UserDetailsRequestModel;
import com.sriraminc.mobileppws.ui.model.response.UserRest;

@Service	
public class UserServiceImpl implements UserService {
	
	Map<String, UserRest> users;
	
	Utils utils;
	
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setPassword(userDetails.getPassword());

		String userId = utils.generateUserID();
		returnValue.setUserid(userId);

		if (users == null) {
			users = new HashMap<>();
			users.put(userId, returnValue);
		}
		
		return returnValue;

	}

}
