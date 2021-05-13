package com.ac1.events_restapi.dto;

import java.util.ArrayList;
import java.util.List;

import com.ac1.events_restapi.entities.Ticket;

public class AttendUpdateDTO {
	private String email;
	private Double balance;
	private List<Ticket> tickets = new ArrayList<>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void addTickets(Ticket ticket) {
		this.tickets.add(ticket);
	}

}
