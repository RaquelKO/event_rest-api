package com.ac1.events_restapi.controllers;

import java.net.URI;
import java.util.List;

import com.ac1.events_restapi.dto.PlaceDTO;
import com.ac1.events_restapi.dto.PlaceInsertDTO;
import com.ac1.events_restapi.dto.PlaceUpdateDTO;
import com.ac1.events_restapi.entities.Place;
import com.ac1.events_restapi.services.PlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/places")
public class PlaceController {

	@Autowired
	private PlaceService placeService;

	@GetMapping
	public ResponseEntity<List<PlaceDTO>> getPlaces() {
		List<PlaceDTO> list = placeService.getPlaces();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
		Place event = placeService.getPlaceById(id);
		return ResponseEntity.ok().body(event);
	}

	@PostMapping
	public ResponseEntity<Place> insert(@RequestBody PlaceInsertDTO placeInsertDTO) {
		Place dto = placeService.insert(placeInsertDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("{id}")
	public ResponseEntity<Place> update(@RequestBody PlaceUpdateDTO placeUpdateDto, @PathVariable Long id) {
		Place dto = placeService.update(id, placeUpdateDto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		placeService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
