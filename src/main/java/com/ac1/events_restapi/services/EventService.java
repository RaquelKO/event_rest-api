package com.ac1.events_restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ac1.events_restapi.dto.EventDTO;
import com.ac1.events_restapi.entities.Event;
import com.ac1.events_restapi.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	public List<EventDTO> getAllEvents() {

		List<Event> list = repository.findAll();

		List<EventDTO> listDTO = new ArrayList<>();
		for (Event event : list) {
			listDTO.add(new EventDTO(event.getId(), event.getName()));
		}

		return listDTO;
	}

	public Event getEventById(Long id) {

		Optional<Event> op = repository.findById(id);
		Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

		return new Event(event);
	}
}
