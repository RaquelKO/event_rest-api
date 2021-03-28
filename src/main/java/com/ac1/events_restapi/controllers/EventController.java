package com.ac1.events_restapi.controllers;

import java.net.URI;

import com.ac1.events_restapi.dto.EventDTO;
import com.ac1.events_restapi.dto.EventInsertDTO;
import com.ac1.events_restapi.dto.EventUpdateDTO;
import com.ac1.events_restapi.entities.Event;
import com.ac1.events_restapi.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService service;

	@GetMapping
	public ResponseEntity<Page<EventDTO>> getAllEvents(

			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "description", defaultValue = "") String description,
			@RequestParam(value = "place", defaultValue = "") String place

	) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<EventDTO> list = service.getAllEvents(pageRequest, name, description, place);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<Event> getEventById(@PathVariable Long id) {
		Event event = service.getEventById(id);
		return ResponseEntity.ok().body(event);
	}

	@PostMapping
	public ResponseEntity<Event> insert(@RequestBody EventInsertDTO insertDto) {
		Event dto = service.insert(insertDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("{id}")
	public ResponseEntity<Event> update(@RequestBody EventUpdateDTO updateDto, @PathVariable Long id) {
		Event dto = service.update(id, updateDto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
