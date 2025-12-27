package com.example.demo.service.impl;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.entity.EventUpdate;
import com.example.demo.entity.User;
import com.example.demo.entity.DeliveryStatus;
import com.example.demo.repository.BroadcastLogRepository;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BroadcastServiceImpl implements BroadcastService {

    @Autowired
    private BroadcastLogRepository broadcastLogRepository;

    @Autowired
    private EventUpdateRepository eventUpdateRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void broadcastUpdate(Long updateId) {
        Optional<EventUpdate> eventUpdate = eventUpdateRepository.findById(updateId);
        if (eventUpdate.isPresent()) {
            // Implementation for broadcasting updates to subscribers
            // This would typically involve sending notifications
            BroadcastLog log = new BroadcastLog();
            log.setEventUpdate(eventUpdate.get());
            log.setDeliveryStatus(DeliveryStatus.SENT);
            broadcastLogRepository.save(log);
        }
    }

    @Override
    public List<BroadcastLog> getLogsForUpdate(Long updateId) {
        Optional<EventUpdate> eventUpdate = eventUpdateRepository.findById(updateId);
        if (eventUpdate.isPresent()) {
            return broadcastLogRepository.findByEventUpdate(eventUpdate.get());
        }
        return List.of();
    }

    @Override
    public void recordDelivery(Long updateId, Long subscriberId, boolean successful) {
        Optional<EventUpdate> eventUpdate = eventUpdateRepository.findById(updateId);
        Optional<User> subscriber = userRepository.findById(subscriberId);
        
        if (eventUpdate.isPresent() && subscriber.isPresent()) {
            BroadcastLog log = new BroadcastLog();
            log.setEventUpdate(eventUpdate.get());
            log.setSubscriber(subscriber.get());
            log.setDeliveryStatus(successful ? DeliveryStatus.DELIVERED : DeliveryStatus.FAILED);
            broadcastLogRepository.save(log);
        }
    }
}