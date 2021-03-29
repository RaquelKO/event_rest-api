package com.ac1.events_restapi.dto;

import java.time.LocalDate;
import java.time.LocalTime;

//import com.fasterxml.jackson.annotation.JsonFormat;

public class EventUpdateDTO {

	private String place;

	// @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate startDate;

	// @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate endDate;

	// @JsonFormat(pattern = "HH:mm:ss")
	private LocalTime startTime;

	// @JsonFormat(pattern = "HH:mm:ss")
	private LocalTime endTime;

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

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

}
