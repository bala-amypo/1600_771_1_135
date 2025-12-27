package com.example.demo.service;

import com.example.demo.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription subscribe(Long eventId);

    void unsubscribe(Long eventId);

    List<Subscription> getMySubscriptions();
}
