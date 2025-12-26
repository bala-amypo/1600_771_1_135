package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "broadcast_logs")
public class BroadcastLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private EventUpdate eventUpdate;

    @ManyToOne(optional = false)
    private User subscriber;

    @Column(nullable = false)
    private String deliveryStatus; // PENDING / SENT / FAILED

    private Instant sentAt;

    @PrePersist
    public void onCreate() {
        this.sentAt = Instant.now();
        if (this.deliveryStatus == null) {
            this.deliveryStatus = "SENT";
        }
    }

    // getters and setters
}
