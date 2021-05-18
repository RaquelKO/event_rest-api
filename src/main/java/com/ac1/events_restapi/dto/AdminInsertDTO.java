package com.ac1.events_restapi.dto;

import javax.validation.constraints.NotBlank;

public class AdminInsertDTO {
	@NotBlank(message = "This field must not be blank!")
	private String name;
	@NotBlank(message = "This field must not be blank!")
	private String email;
	@NotBlank(message = "This field must not be blank!")
	private String phoneNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
