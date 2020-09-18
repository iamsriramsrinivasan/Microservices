package com.sriraminc.mobileppws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	
	@NotNull(message="FirstName cannot be null")
	@Size(min=2, message="FirstName should be minimum 2 characters")
	private String firstName;
	
	@NotNull(message="LastName cannot be null")
	@Size(min=2, message="LastName should be minimum 2 characters")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
