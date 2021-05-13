package com.ac1.events_restapi.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate startDate;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate endDate;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime startTime;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime endTime;

	private String emailContact;
	private Long amountFreeTickets;
	private Long amountPayedTickets;
	private Double priceTicket;

	@ManyToMany
	private List<Place> places = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "EVENT_ADMIN_ID")
	private Admin admin;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "EVENT_ID")
	private List<Ticket> tickets = new ArrayList<>();

	public Event() {

	}

	public Event(Event event) {
		setId(event.getId());
		setName(event.getName());
		setDescription(event.getDescription());
		setStartDate(event.getStartDate());
		setEndDate(event.getEndDate());
		setStartTime(event.getStartTime());
		setEndTime(event.getEndTime());
		setEmailContact(event.getEmailContact());
		setAmountFreeTickets(event.getAmountFreeTickets());
		setAmountPayedTickets(event.getAmountPayedTickets());
		// addPlace(event.getPlaces().get(0));
		setPriceTicket(event.getPriceTicket());
		setAdmin(event.getAdmin());
	}

	public Event(EventInsertDTO insertDto) {
		this.name = insertDto.getName();
		this.description = insertDto.getDescription();
		this.startDate = insertDto.getStartDate();
		this.endDate = insertDto.getEndDate();
		this.startTime = insertDto.getStartTime();
		this.endTime = insertDto.getEndTime();
		this.emailContact = insertDto.getEmailContact();
		this.amountFreeTickets = insertDto.getAmountFreeTickets();
		this.amountPayedTickets = insertDto.getAmountPayedTickets();
		this.priceTicket = insertDto.getPriceTicket();
		this.places = insertDto.getPlaces();
		this.admin = insertDto.getAdmin();
		this.tickets = insertDto.getTickets();
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
