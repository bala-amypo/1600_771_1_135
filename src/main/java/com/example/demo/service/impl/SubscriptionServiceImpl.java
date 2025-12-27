package com.example.demo.service.impl;

import com.example.demo.entity.Event;
import com.example.demo.entity.Subscription;
import com.example.demo.entity.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public SubscriptionServiceImpl(
            SubscriptionRepository subscriptionRepository,
            EventRepository eventRepository,
            UserRepository userRepository) {

        this.subscriptionRepository = subscriptionRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Subscription subscribe(Long userId, Long eventId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setEvent(event);

        return subscriptionRepository.save(subscription);
    }

    @Override
    public void unsubscribe(Long userId, Long eventId) {
        subscriptionRepository.deleteByUserIdAndEventId(userId, eventId);
    }

    @Override
    public List<Subscription> getUserSubscriptions(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    @Override
    public boolean isSubscribed(Long userId, Long eventId) {
        return subscriptionRepository.existsByUserIdAndEventId(userId, eventId);
    }
}
