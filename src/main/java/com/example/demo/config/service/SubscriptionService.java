package com.example.demo.service;

import com.example.demo.entity.Subscription;
import com.example.demo.entity.User;
import com.example.demo.entity.Event;

import java.util.List;

public interface SubscriptionService {

    // Method to subscribe a user to an event
    Subscription subscribe(Long userId, Long eventId);

    // Method to unsubscribe a user from an event
    void unsubscribe(Long userId, Long eventId);

    // Method to get a list of all subscriptions for a user
    List<Subscription> getSubscriptionsForUser(Long userId);

    // Method to check if a user is subscribed to an event
    boolean checkSubscription(Long userId, Long eventId);
}
