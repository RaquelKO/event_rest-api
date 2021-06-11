package com.ac1.events_restapi.dto;

import java.util.ArrayList;
import java.util.List;

public class TicketEventDTO {

	private Long amountFreeTickets;
	private Long freeTicketsSelled;
	private Long amountPayedTickets;
	private Long payedTicketsSelled;
	private List<TicketListedDTO> tickets = new ArrayList<>();

	public TicketEventDTO() {

	}

	public TicketEventDTO(TicketEventDTO ticketEventDTO) {
		setAmountFreeTickets(ticketEventDTO.getAmountFreeTickets());
		setFreeTicketsSelled(ticketEventDTO.getFreeTicketsSelled());
		setAmountPayedTickets(ticketEventDTO.getAmountFreeTickets());
		setPayedTicketsSelled(ticketEventDTO.getPayedTicketsSelled());
		setTickets(ticketEventDTO.getTickets());
	}

	public List<TicketListedDTO> getTickets() {
		return tickets;
	}

	public void addTickets(TicketListedDTO tickets) {
		this.tickets.add(tickets);
	}

	public void setTickets(List<TicketListedDTO> tickets) {
		this.tickets = tickets;
	}

	public Long getAmountFreeTickets() {
		return amountFreeTickets;
	}

	public void setAmountFreeTickets(Long amountFreeTickets) {
		this.amountFreeTickets = amountFreeTickets;
	}

	public Long getFreeTicketsSelled() {
		return freeTicketsSelled;
	}

	public void setFreeTicketsSelled(Long freeTicketsSelled) {
		this.freeTicketsSelled = freeTicketsSelled;
	}

	public Long getAmountPayedTickets() {
		return amountPayedTickets;
	}

	public void setAmountPayedTickets(Long amountPayedTickets) {
		this.amountPayedTickets = amountPayedTickets;
	}

	public Long getPayedTicketsSelled() {
		return payedTicketsSelled;
	}

	public void setPayedTicketsSelled(Long payedTicketsSelled) {
		this.payedTicketsSelled = payedTicketsSelled;
	}

}
