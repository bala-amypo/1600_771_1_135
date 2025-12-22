package com.example.demo.service;

import com.example.demo.entity.EventUpdate;
import java.util.List;

public interface EventUpdateService {

    EventUpdate addUpdate(EventUpdate eventUpdate);

    List<EventUpdate> getUpdatesByEventId(Long eventId);
}
