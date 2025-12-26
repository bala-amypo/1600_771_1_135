package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class BroadcastLog {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private EventUpdate eventUpdate;

    @ManyToOne
    private User subscriber;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus = DeliveryStatus.SENT;

    private Instant sentAt;

    @PrePersist
    public void onCreate() {
        sentAt = Instant.now();
    }

    // getters and setters
}
