package com.example.demo.config.service.impl;

import com.example.demo.config.entity.BroadcastLog;
import com.example.demo.repository.BroadcastLogRepository;
import com.example.demo.config.service.BroadcastService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BroadcastServiceImpl implements BroadcastService {

    private final BroadcastLogRepository repository;

    public BroadcastServiceImpl(BroadcastLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void triggerBroadcast(Long updateId) {

        // Since no subscribers exist, we create a single log entry
        BroadcastLog log = new BroadcastLog();
        log.setEventId(updateId);   // reuse eventId as updateId
        log.setMessage("Broadcast sent for update " + updateId);
        log.setChannel("SYSTEM");
        log.setBroadcastTime(LocalDateTime.now());

        repository.save(log);
    }

    @Override
    public List<BroadcastLog> getLogsForUpdate(Long updateId) {
        return repository.findByEventId(updateId);
    }
}
