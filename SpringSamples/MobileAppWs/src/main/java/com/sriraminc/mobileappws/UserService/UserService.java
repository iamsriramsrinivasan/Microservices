package com.sriraminc.mobileappws.UserService;

import com.sriraminc.mobileppws.ui.model.request.UserDetailsRequestModel;
import com.sriraminc.mobileppws.ui.model.response.UserRest;

public interface UserService {
	
	UserRest createUser(UserDetailsRequestModel userDetails);

}
