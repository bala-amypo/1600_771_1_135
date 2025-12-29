package com.example.demo.service;

import com.example.demo.entity.Event;
import com.example.demo.entity.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public Event createEvent(Event event) {
        Long publisherId = event.getPublisher().getId();

        User publisher = userRepository.findById(publisherId)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));

        event.setPublisher(publisher);
        return eventRepository.save(event);
    }
}
