package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_updates")
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String updateMessage;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public EventUpdate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUpdateMessage() {
        return updateMessage;
    }

    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
