package com.ac1.events_restapi.repositories;

import com.ac1.events_restapi.entities.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	@Query("SELECT e FROM Event e " + " WHERE " + " (LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND "
			+ " (LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%'))) AND "
			+ " (LOWER(e.place) LIKE LOWER(CONCAT('%', :place, '%'))) AND " + " e.date > TO_DATE(:date, 'DD/MM/YYYY')")
	public Page<Event> find(Pageable pageRequest, String name, String description, String place, String date);

	@Query("SELECT e FROM Event e " + " WHERE " + " (LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND "
			+ " (LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%'))) AND "
			+ " (LOWER(e.place) LIKE LOWER(CONCAT('%', :place, '%')))")
	public Page<Event> findNoDate(Pageable pageRequest, String name, String description, String place);
}
