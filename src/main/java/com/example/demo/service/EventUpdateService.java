package com.example.demo.service;

import com.example.demo.entity.EventUpdate;

import java.util.List;

public interface EventUpdateService {

    EventUpdate create(EventUpdate update, Long eventId);

    List<EventUpdate> getUpdatesByEvent(Long eventId);
}
