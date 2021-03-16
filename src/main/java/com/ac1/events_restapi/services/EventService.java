package com.ac1.events_restapi.services;

import java.util.ArrayList;
import java.util.List;

import com.ac1.events_restapi.dto.EventDTO;
import com.ac1.events_restapi.entities.Event;
import com.ac1.events_restapi.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	public List<EventDTO> getAllEvents() {

		List<Event> list = repository.getAllEvents();

		List<EventDTO> listDTO = new ArrayList<>();
		for (Event event : list) {
			listDTO.add(new EventDTO(event.getId(), event.getName()));
		}

		return listDTO;
	}
}
