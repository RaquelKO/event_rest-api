package com.ac1.events_restapi.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EventUpdateDTO {

	private String place;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate endDate;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime time;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime endTime;

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

}
