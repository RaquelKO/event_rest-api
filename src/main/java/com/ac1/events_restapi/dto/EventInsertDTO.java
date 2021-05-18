package com.ac1.events_restapi.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.ac1.events_restapi.entities.Admin;
import com.ac1.events_restapi.entities.Place;
import com.ac1.events_restapi.entities.Ticket;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EventInsertDTO {

	@NotBlank(message = "This field must not be blank!")
	private String name;

	@NotBlank(message = "This field must not be blank!")
	private String description;

	private Place place;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate startDate;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate endDate;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime startTime;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime endTime;

	@NotBlank(message = "This field must not be blank!")
	private String emailContact;

	private Long amountFreeTickets;
	private Long amountPayedTickets;
	private Double priceTicket;
	private List<Place> places = new ArrayList<>();
	private Admin admin;
	private List<Ticket> tickets = new ArrayList<>();

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

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
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

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public Long getAmountFreeTickets() {
		return amountFreeTickets;
	}

	public void setAmountFreeTickets(Long amountFreeTickets) {
		this.amountFreeTickets = amountFreeTickets;
	}

	public Long getAmountPayedTickets() {
		return amountPayedTickets;
	}

	public void setAmountPayedTickets(Long amountPayedTickets) {
		this.amountPayedTickets = amountPayedTickets;
	}

	public Double getPriceTicket() {
		return priceTicket;
	}

	public void setPriceTicket(Double priceTicket) {
		this.priceTicket = priceTicket;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void addPlace(Place place) {
		this.places.add(place);
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}

}
