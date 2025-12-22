package com.example.demo.repository;

import com.example.demo.config.entity.EventUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventUpdateRepository extends JpaRepository<EventUpdate, Long> {

    List<EventUpdate> findByEventId(Long eventId);
}
