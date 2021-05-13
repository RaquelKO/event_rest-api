package com.ac1.events_restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ac1.events_restapi.dto.AttendDTO;
import com.ac1.events_restapi.dto.AttendInsertDTO;
import com.ac1.events_restapi.dto.AttendUpdateDTO;
import com.ac1.events_restapi.entities.Attend;
import com.ac1.events_restapi.repositories.AttendRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AttendService {

	@Autowired
	private AttendRepository attendRepository;

	public List<AttendDTO> getAttends() {
		List<Attend> list = attendRepository.findAll();
		List<AttendDTO> listDTO = new ArrayList<>();
		for (Attend attend : list) {
			listDTO.add(new AttendDTO(attend.getId(), attend.getName(), attend.getEmail(), attend.getBalance()));
		}

		return listDTO;
	}

	public Attend insert(AttendInsertDTO attendInsertDTO) {

		Attend entity = new Attend(attendInsertDTO);
		entity = attendRepository.save(entity);
		return new Attend(entity);
	}

	public Attend getAttendById(Long id) {

		Optional<Attend> op = attendRepository.findById(id);
		Attend attend = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found"));

		return new Attend(attend);
	}

	public Attend update(Long id, AttendUpdateDTO attendUpdateDto) {
		try {
			Attend entity = attendRepository.getOne(id);
			entity.setEmail(attendUpdateDto.getEmail());
			entity.setBalance(attendUpdateDto.getBalance());

			entity = attendRepository.save(entity);
			return new Attend(entity);
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found");
		}
	}

	public void delete(Long id) {
		try {
			attendRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found");
		}
	}
}
