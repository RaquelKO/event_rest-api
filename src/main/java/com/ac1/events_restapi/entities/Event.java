package com.ac1.events_restapi.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ac1.events_restapi.dto.EventInsertDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_EVENT")
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;
	private String place;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate endDate;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime time;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime endTime;

	private String email;

	public Event() {

	}

	public Event(Event event) {
		setId(event.getId());
		setName(event.getName());
		setDescription(event.getDescription());
		setPlace(event.getPlace());
		setDate(event.getDate());
		setEndDate(event.getEndDate());
		setTime(event.getTime());
		setEndTime(event.getEndTime());
		setEmail(event.getEmail());
	}

	public Event(EventInsertDTO insertDto) {
		this.name = insertDto.getName();
		this.description = insertDto.getDescription();
		this.place = insertDto.getPlace();
		this.date = insertDto.getDate();
		this.endDate = insertDto.getEndDate();
		this.time = insertDto.getTime();
		this.endTime = insertDto.getEndTime();
		this.email = insertDto.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
