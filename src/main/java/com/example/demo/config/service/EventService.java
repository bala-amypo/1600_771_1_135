package com.example.demo.config.service;

import com.example.demo.config.entity.Event;
import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event getEventById(Long id);

    List<Event> getAllEvents();

    List<Event> getActiveEvents();
}
