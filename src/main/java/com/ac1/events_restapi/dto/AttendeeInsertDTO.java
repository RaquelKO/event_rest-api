package com.ac1.events_restapi.dto;

import javax.validation.constraints.NotBlank;

public class AttendeeInsertDTO {

	@NotBlank(message = "This field must not be blank!")
	private String name;

	@NotBlank(message = "This field must not be blank!")
	private String email;

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

}
