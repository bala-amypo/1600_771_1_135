package com.example.demo.config.controller;

import com.example.demo.config.entity.BroadcastLog;
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

    @PostMapping("/trigger/{updateId}")
    public String triggerBroadcast(@PathVariable Long updateId) {
        service.triggerBroadcast(updateId);
        return "Broadcast triggered for update " + updateId;
    }

    @GetMapping("/logs/{updateId}")
    public List<BroadcastLog> getLogs(@PathVariable Long updateId) {
        return service.getLogsForUpdate(updateId);
    }
}
