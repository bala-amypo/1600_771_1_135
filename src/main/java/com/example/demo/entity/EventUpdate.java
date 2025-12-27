package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Event event;

    private String updateContent;
    private String updateType;
    private Instant timestamp;

    @PrePersist
    public void onCreate() {
        timestamp = Instant.now();
    }

    public Long getId() { return id; }
    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
}
