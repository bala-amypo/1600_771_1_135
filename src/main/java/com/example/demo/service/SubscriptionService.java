package com.example.demo.config.service;

import com.example.demo.entity.Subscription;
import java.util.List;

public interface SubscriptionService {

    Subscription createSubscription(Subscription subscription);

    Subscription getSubscriptionById(Long id);

    List<Subscription> getAllSubscriptions();

    Subscription updateSubscription(Long id, Subscription subscription);

    void deleteSubscription(Long id);
}
