package com.example.demo.repository;

import com.example.demo.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    // You can add custom queries here if needed

    // Example of a custom query to find subscriptions by type
    List<Subscription> findBySubscriptionType(String subscriptionType);
    
    // Example of finding subscriptions by email
    Optional<Subscription> findByEmail(String email);
}
