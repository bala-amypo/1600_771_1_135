package com.example.demo.service.impl;

import com.example.demo.entity.Event;
import com.example.demo.entity.Subscription;
import com.example.demo.entity.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.service.SubscriptionService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔴 THIS IS CRITICAL
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final EventRepository eventRepository;
    private final UserService userService;

    public SubscriptionServiceImpl(
            SubscriptionRepository subscriptionRepository,
            EventRepository eventRepository,
            UserService userService) {

        this.subscriptionRepository = subscriptionRepository;
        this.eventRepository = eventRepository;
        this.userService = userService;
    }

    @Override
    public Subscription subscribe(Long eventId) {
        User user = userService.getCurrentUser();
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setEvent(event);

        return subscriptionRepository.save(subscription);
    }

    @Override
    public void unsubscribe(Long eventId) {
        User user = userService.getCurrentUser();
        subscriptionRepository.deleteByUserIdAndEventId(user.getId(), eventId);
    }

    @Override
    public List<Subscription> getMySubscriptions() {
        User user = userService.getCurrentUser();
        return subscriptionRepository.findByUserId(user.getId());
    }
}
