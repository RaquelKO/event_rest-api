package com.ac1.events_restapi.dto;

import java.time.LocalDate;

import com.ac1.events_restapi.entities.Event;
//import com.fasterxml.jackson.annotation.JsonFormat;

public class EventDTO {
	private Long id;
	private String name;
	private String description;
	private String place;

	// @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate startDate;

	public EventDTO() {

	}

	public EventDTO(Long id, String name, String description, String place, LocalDate startDate) {
		setId(id);
		setName(name);
		setDescription(description);
		setPlace(place);
		setStartDate(startDate);
	}

	public EventDTO(Event event) {
		setId(event.getId());
		setName(event.getName());
		setDescription(event.getDescription());
		setPlace(event.getPlace());
		setStartDate(event.getStartDate());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

}
