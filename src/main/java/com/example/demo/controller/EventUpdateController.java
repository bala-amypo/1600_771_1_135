package com.example.demo.config.controller;

import com.example.demo.config.entity.EventUpdate;
import com.example.demo.config.service.EventUpdateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event-updates")
public class EventUpdateController {

    private final EventUpdateService service;

    public EventUpdateController(EventUpdateService service) {
        this.service = service;
    }

    @PostMapping
    public EventUpdate addUpdate(@RequestBody EventUpdate eventUpdate) {
        return service.addUpdate(eventUpdate);
    }

    @GetMapping("/event/{eventId}")
    public List<EventUpdate> getUpdates(@PathVariable Long eventId) {
        return service.getUpdatesByEventId(eventId);
    }
}
