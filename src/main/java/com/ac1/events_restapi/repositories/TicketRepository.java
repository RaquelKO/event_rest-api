package com.ac1.events_restapi.repositories;

import com.ac1.events_restapi.entities.Ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query("SELECT t FROM Ticket t")
	public Page<Ticket> findAttendeePageable(Pageable pageRequest);

}
