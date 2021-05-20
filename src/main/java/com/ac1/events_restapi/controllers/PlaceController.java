package com.ac1.events_restapi.controllers;

import java.net.URI;

import javax.validation.Valid;

import com.ac1.events_restapi.dto.PlaceDTO;
import com.ac1.events_restapi.dto.PlaceInsertDTO;
import com.ac1.events_restapi.dto.PlaceUpdateDTO;
import com.ac1.events_restapi.entities.Place;
import com.ac1.events_restapi.services.PlaceService;

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
@RequestMapping("/places")
public class PlaceController {

	@Autowired
	private PlaceService placeService;

	@GetMapping
	public ResponseEntity<Page<PlaceDTO>> getPlaces(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<PlaceDTO> list = placeService.getPlaces(pageRequest);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
		Place event = placeService.getPlaceById(id);
		return ResponseEntity.ok().body(event);
	}

	@PostMapping
	public ResponseEntity<Place> insert(@Valid @RequestBody PlaceInsertDTO placeInsertDTO) {
		Place dto = placeService.insert(placeInsertDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("{id}")
	public ResponseEntity<Place> update(@Valid @RequestBody PlaceUpdateDTO placeUpdateDto, @PathVariable Long id) {
		Place dto = placeService.update(id, placeUpdateDto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		placeService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
