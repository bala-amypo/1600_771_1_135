package com.example.demo.config.service.impl;

import com.example.demo.config.entity.Broadcast;
import com.example.demo.repository.BroadcastRepository;
import com.example.demo.config.service.BroadcastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadcastServiceImpl implements BroadcastService {

    private final BroadcastRepository repository;

    public BroadcastServiceImpl(BroadcastRepository repository) {
        this.repository = repository;
    }

    @Override
    public Broadcast createBroadcast(Broadcast broadcast) {
        return repository.save(broadcast);
    }

    @Override
    public List<Broadcast> getBroadcastsByEventId(Long eventId) {
        return repository.findByEventId(eventId);
    }
}
