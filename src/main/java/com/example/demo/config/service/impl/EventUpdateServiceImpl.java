package com.example.demo.config.service.impl;

import com.example.demo.config.entity.EventUpdate;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.config.service.EventUpdateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventUpdateServiceImpl implements EventUpdateService {

    private final EventUpdateRepository repository;

    public EventUpdateServiceImpl(EventUpdateRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventUpdate addUpdate(EventUpdate eventUpdate) {
        return repository.save(eventUpdate);
    }

    @Override
    public List<EventUpdate> getUpdatesByEventId(Long eventId) {
        return repository.findByEventId(eventId);
    }
}
