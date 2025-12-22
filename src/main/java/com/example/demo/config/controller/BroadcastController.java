package com.example.demo.config.controller;

import com.example.demo.config.entity.Broadcast;
import com.example.demo.config.service.BroadcastService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/broadcasts")
public class BroadcastController {

    private final BroadcastService service;

    public BroadcastController(BroadcastService service) {
        this.service = service;
    }

    @PostMapping
    public Broadcast createBroadcast(@RequestBody Broadcast broadcast) {
        return service.createBroadcast(broadcast);
    }

    @GetMapping("/event/{eventId}")
    public List<Broadcast> getBroadcasts(@PathVariable Long eventId) {
        return service.getBroadcastsByEventId(eventId);
    }
}
