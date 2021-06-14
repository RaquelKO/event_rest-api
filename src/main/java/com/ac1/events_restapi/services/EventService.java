package com.ac1.events_restapi.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ac1.events_restapi.dto.EventDTO;
import com.ac1.events_restapi.dto.EventInsertDTO;
import com.ac1.events_restapi.dto.EventUpdateDTO;
import com.ac1.events_restapi.dto.TicketEventDTO;
import com.ac1.events_restapi.dto.TicketListedDTO;
import com.ac1.events_restapi.dto.TicketSellDTO;
import com.ac1.events_restapi.entities.Admin;
import com.ac1.events_restapi.entities.Attendee;
import com.ac1.events_restapi.entities.Event;
import com.ac1.events_restapi.entities.Place;
import com.ac1.events_restapi.entities.Ticket;
import com.ac1.events_restapi.entities.TicketType;
import com.ac1.events_restapi.repositories.AdminRepository;
import com.ac1.events_restapi.repositories.AttendeeRepository;
import com.ac1.events_restapi.repositories.EventRepository;
import com.ac1.events_restapi.repositories.PlaceRepository;
import com.ac1.events_restapi.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private PlaceRepository placeRepository;

	@Autowired
	private AttendeeRepository attendeeRepository;

	@Autowired
	private TicketRepository ticketRepository;

	public Page<EventDTO> getAllEvents(PageRequest pageRequest, String name, String description, String startDate) {

		Page<Event> list = repository.find(pageRequest, name, description, startDate);
		return list.map(e -> new EventDTO(e));
	}

	public Page<EventDTO> getAllEventsButDate(PageRequest pageRequest, String name, String description) {

		Page<Event> list = repository.findNoDate(pageRequest, name, description);
		return list.map(e -> new EventDTO(e));
	}

	public Event getEventById(Long id) {

		Optional<Event> op = repository.findById(id);
		Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

		return new Event(event);
	}

	public Event insert(EventInsertDTO eventInsertDTO) {

		if (eventInsertDTO.getStartDate().compareTo(eventInsertDTO.getEndDate()) > 0) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "The end date must be after the start date!");
		} else {

			Optional<Admin> op = adminRepository.findById(eventInsertDTO.getIdAdmin());
			Admin admin = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found"));

			Event entity = new Event(eventInsertDTO);
			entity.setAdmin(admin);
			entity = repository.save(entity);
			return new Event(entity);
		}
	}

	public Event update(Long id, EventUpdateDTO updateDto) {
		try {
			Event entity = repository.getOne(id);

			if (entity.getFreeTicketsSelled() > 0 || entity.getPayedTicketsSelled() > 0) {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN,
						"This event has sold tickets, therefore it can no longer be modified!");
			}

			entity.setStartDate(updateDto.getStartDate());
			entity.setEndDate(updateDto.getEndDate());
			entity.setStartTime(updateDto.getStartTime());
			entity.setEndTime(updateDto.getEndTime());

			if (updateDto.getStartDate().compareTo(updateDto.getEndDate()) > 0) {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN, "The end date must be after the start date!");
			} else {
				entity = repository.save(entity);
				return new Event(entity);
			}

		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
		}
	}

	public void delete(Long id) {
		try {
			Event entity = repository.getOne(id);

			if (entity.getFreeTicketsSelled() > 0 || entity.getPayedTicketsSelled() > 0) {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN,
						"This event has sold tickets, therefore it can not be deleted!");
			}

			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
		}
	}

	public Event insertPlace(Long id, Long idPlace) {

		Optional<Event> op = repository.findById(id);
		Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

		Optional<Place> opPlace = placeRepository.findById(idPlace);
		Place place = opPlace.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found"));

		for (Event e : place.getEvents()) {
			if ((event.getStartDate().isBefore(e.getStartDate()) && event.getEndDate().isBefore(e.getStartDate()))
					|| (event.getStartDate().isAfter(e.getEndDate()) && event.getEndDate().isAfter(e.getEndDate()))) {
			} else {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This place is not available on this date!");
			}
		}

		if (event.getPlaces().contains(place)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This place is already scheduled for this event!");
		} else if (event.getStartDate().isBefore(LocalDate.now())
				|| (event.getStartDate().isEqual(LocalDate.now()) && event.getStartTime().isBefore(LocalTime.now()))) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Sorry, this event can no longer be modified!");
		} else {
			event.addPlace(place);
			event = repository.save(event);
			return new Event(event);
		}

	}

	public void removePlaceFromEvent(Long id, Long idPlace) {

		Optional<Event> op = repository.findById(id);
		Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

		Optional<Place> opPlace = placeRepository.findById(idPlace);
		Place place = opPlace.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found"));

		if (event.getPlaces().contains(place) && (event.getStartDate().isBefore(LocalDate.now())
				|| (event.getStartDate().isEqual(LocalDate.now()) && event.getStartTime().isBefore(LocalTime.now())))) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"Sorry, this place can no longer be deleted from this event!");
		} else if (event.getPlaces().contains(place)) {
			event.getPlaces().remove(place);
			place.getEvents().remove(event);
			repository.save(event);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This place is not scheduled for this event");
		}

	}

	public Ticket sellTicket(Long id, TicketSellDTO ticketSellDTO) {

		Optional<Event> op = repository.findById(id);
		Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

		Optional<Attendee> opAttendee = attendeeRepository.findById(ticketSellDTO.getIdAttendee());
		Attendee attendee = opAttendee
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attendee not found"));

		if (event.getStartDate().isBefore(LocalDate.now())
				|| (event.getStartDate().isEqual(LocalDate.now()) && event.getStartTime().isBefore(LocalTime.now()))) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"Sorry, you can no longer purchase tickets for this event!");
		}

		if ((ticketSellDTO.getType().equals(TicketType.FREE) && event.getAmountFreeTickets() > 0
				&& (event.getFreeTicketsSelled() < event.getAmountFreeTickets()))
				|| (ticketSellDTO.getType().equals(TicketType.PAYED) && event.getAmountPayedTickets() > 0
						&& event.getPayedTicketsSelled() < event.getAmountPayedTickets())) {

			Ticket ticket = new Ticket();

			ticket.setDate(Instant.now());
			ticket.setIdAttendee(attendee.getId());
			ticket.setPrice(event.getPriceTicket());
			ticket.setType(ticketSellDTO.getType());
			attendee.addTicket(ticket);
			event.addTicket(ticket);

			if (ticketSellDTO.getType().equals(TicketType.FREE)) {
				event.setFreeTicketsSelled(event.getFreeTicketsSelled() + 1);
			} else {
				event.setPayedTicketsSelled(event.getPayedTicketsSelled() + 1);
			}

			ticketRepository.save(ticket);
			attendeeRepository.save(attendee);
			repository.save(event);

			return new Ticket(ticket);
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"Sorry, these type of tickets are no longer available for this event!");
		}
	}

	public void returnTicket(Long id, Long idTicket) {

		Optional<Event> op = repository.findById(id);
		Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

		Optional<Ticket> opTicket = ticketRepository.findById(idTicket);
		Ticket ticket = opTicket
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found"));

		Attendee attendee = null;
		for (Attendee a : attendeeRepository.findAll()) {
			for (Ticket t : a.getTickets()) {
				if (t.equals(ticket)) {
					attendee = a;
				}
			}
		}

		if (ticket.getType().equals(TicketType.PAYED)) {
			attendee.setBalance(attendee.getBalance() + ticket.getPrice());
			event.setPayedTicketsSelled(event.getPayedTicketsSelled() - 1);
		} else {
			event.setFreeTicketsSelled(event.getFreeTicketsSelled() - 1);
		}

		attendee.getTickets().remove(ticket);
		event.getTickets().remove(ticket);
		ticketRepository.delete(ticket);

		attendeeRepository.save(attendee);
		repository.save(event);
	}

	public TicketEventDTO getTickets(Long id) {

		Optional<Event> op = repository.findById(id);
		Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

		List<Attendee> attendees = attendeeRepository.findAll();

		TicketEventDTO ticketEventDTO = new TicketEventDTO();
		for (Ticket ticket : event.getTickets()) {
			for (Attendee attendee : attendees) {
				for (Ticket attendeeTicket : attendee.getTickets()) {
					if (attendeeTicket.equals(ticket)) {
						ticketEventDTO
								.addTickets(new TicketListedDTO(ticket.getId(), ticket.getType(), attendee.getName()));
					}
				}
			}
		}

		ticketEventDTO.setAmountFreeTickets(event.getAmountFreeTickets());
		ticketEventDTO.setFreeTicketsSelled(event.getFreeTicketsSelled());
		ticketEventDTO.setAmountPayedTickets(event.getAmountFreeTickets());
		ticketEventDTO.setPayedTicketsSelled(event.getPayedTicketsSelled());
		return new TicketEventDTO(ticketEventDTO);
	}
}
