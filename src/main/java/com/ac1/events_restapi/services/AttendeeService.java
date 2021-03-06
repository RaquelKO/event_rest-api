package com.ac1.events_restapi.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ac1.events_restapi.dto.AttendeeDTO;
import com.ac1.events_restapi.dto.AttendeeInsertDTO;
import com.ac1.events_restapi.dto.AttendeeUpdateDTO;
import com.ac1.events_restapi.entities.Attendee;
import com.ac1.events_restapi.repositories.AttendeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AttendeeService {

	@Autowired
	private AttendeeRepository attendeeRepository;

	public Page<AttendeeDTO> getAttendees(PageRequest pageRequest) {
		Page<Attendee> list = attendeeRepository.findAttendeePageable(pageRequest);
		return list.map(attendee -> new AttendeeDTO(attendee));
	}

	public Attendee insert(AttendeeInsertDTO attendInsertDTO) {

		Attendee entity = new Attendee(attendInsertDTO);
		for (Attendee a : attendeeRepository.findAll()) {
			if (entity.getEmail().equals(a.getEmail())) {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN,
						"This email address is already being used, please choose another one.");
			}
		}
		entity = attendeeRepository.save(entity);
		return new Attendee(entity);
	}

	public Attendee getAttendeeById(Long id) {

		Optional<Attendee> op = attendeeRepository.findById(id);
		Attendee attend = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attendee not found"));

		return new Attendee(attend);
	}

	public Attendee update(Long id, AttendeeUpdateDTO attendUpdateDto) {
		try {
			Attendee entity = attendeeRepository.getOne(id);
			for (Attendee a : attendeeRepository.findAll()) {
				if (attendUpdateDto.getEmail().equals(a.getEmail())) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN,
							"This email address is already being used, please choose another one.");
				}
			}
			entity.setEmail(attendUpdateDto.getEmail());
			entity = attendeeRepository.save(entity);
			return new Attendee(entity);
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attendee not found");
		}
	}

	public void delete(Long id) {
		try {
			attendeeRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attendee not found");
		}
	}
}
