package com.amydegregorio.activiti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amydegregorio.activiti.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
