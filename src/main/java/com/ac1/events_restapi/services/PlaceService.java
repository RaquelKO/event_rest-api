package com.ac1.events_restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ac1.events_restapi.dto.PlaceDTO;
import com.ac1.events_restapi.dto.PlaceInsertDTO;
import com.ac1.events_restapi.dto.PlaceUpdateDTO;
import com.ac1.events_restapi.entities.Place;
import com.ac1.events_restapi.repositories.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlaceService {

	@Autowired
	private PlaceRepository placeRepository;

	public List<PlaceDTO> getPlaces() {
		List<Place> list = placeRepository.findAll();
		List<PlaceDTO> listDTO = new ArrayList<>();
		for (Place place : list) {
			listDTO.add(new PlaceDTO(place.getId(), place.getName(), place.getAddress()));
		}

		return listDTO;
	}

	public Place insert(PlaceInsertDTO placeInsertDTO) {

		Place entity = new Place(placeInsertDTO);
		entity = placeRepository.save(entity);
		return new Place(entity);
	}

	public Place getPlaceById(Long id) {

		Optional<Place> op = placeRepository.findById(id);
		Place place = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found"));

		return new Place(place);
	}

	public Place update(Long id, PlaceUpdateDTO placeUpdateDto) {
		try {
			Place entity = placeRepository.getOne(id);
			entity.setName(placeUpdateDto.getName());

			entity = placeRepository.save(entity);
			return new Place(entity);
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found");
		}
	}

	public void delete(Long id) {
		try {
			placeRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found");
		}
	}
}
