package com.example.demo.config.service.impl;

import com.example.demo.config.entity.BroadcastLog;
import com.example.demo.repository.BroadcastLogRepository;
import com.example.demo.config.service.BroadcastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadcastServiceImpl implements BroadcastService {

    private final BroadcastLogRepository repository;

    public BroadcastServiceImpl(BroadcastLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void triggerBroadcast(Long updateId) {

        BroadcastLog log = new BroadcastLog();
        log.setEventId(updateId);
        log.setMessage("Broadcast sent for update " + updateId);
        log.setChannel("SYSTEM");
        // ❌ DO NOT set broadcastTime (already set in constructor)

        repository.save(log);
    }

    @Override
    public List<BroadcastLog> getLogsForUpdate(Long updateId) {
        return repository.findByEventId(updateId);
    }
}
