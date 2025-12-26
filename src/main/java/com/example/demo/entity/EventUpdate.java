package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "event_updates")
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Event event;

    @Column(nullable = false)
    private String updateContent;

    @Column(nullable = false)
    private String updateType; // INFO / WARNING / CRITICAL

    private Instant postedAt;

    @PrePersist
    public void onCreate() {
        this.postedAt = Instant.now();
    }

    // getters and setters
}
