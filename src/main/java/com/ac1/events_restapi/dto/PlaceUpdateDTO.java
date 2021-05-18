package com.ac1.events_restapi.dto;

import javax.validation.constraints.NotBlank;

public class PlaceUpdateDTO {

	@NotBlank(message = "This field must not be blank!")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
