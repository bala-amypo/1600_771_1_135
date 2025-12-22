package com.example.demo.config.service;

import com.example.demo.config.entity.EventUpdate;
import java.util.List;

public interface EventUpdateService {

    EventUpdate addUpdate(EventUpdate eventUpdate);

    List<EventUpdate> getUpdatesByEventId(Long eventId);
}
