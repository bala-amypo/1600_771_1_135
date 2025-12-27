package com.example.demo.service.impl;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.repository.BroadcastLogRepository;
import com.example.demo.service.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BroadcastServiceImpl implements BroadcastService {

    @Autowired
    private BroadcastLogRepository broadcastLogRepository;

    @Override
    public void broadcastUpdate(Long updateId) {
        // Implementation for broadcasting updates
        // This would typically involve sending notifications to subscribers
        BroadcastLog log = new BroadcastLog();
        log.setUpdateId(updateId);
        log.setBroadcastTime(LocalDateTime.now());
        log.setSuccessful(true);
        broadcastLogRepository.save(log);
    }

    @Override
    public List<BroadcastLog> getLogsForUpdate(Long updateId) {
        return broadcastLogRepository.findByUpdateId(updateId);
    }

    @Override
    public void recordDelivery(Long updateId, Long subscriberId, boolean successful) {
        BroadcastLog log = new BroadcastLog();
        log.setUpdateId(updateId);
        log.setSubscriberId(subscriberId);
        log.setSuccessful(successful);
        log.setBroadcastTime(LocalDateTime.now());
        broadcastLogRepository.save(log);
    }
}