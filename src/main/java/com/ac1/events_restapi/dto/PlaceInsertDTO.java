package com.ac1.events_restapi.dto;

import javax.validation.constraints.NotBlank;

public class PlaceInsertDTO {

	@NotBlank(message = "This field must not be blank!")
	private String name;

	@NotBlank(message = "This field must not be blank!")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
