package com.example.demo.entity;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private String category;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private User publisher;

    private Boolean isActive = true;

    @CreationTimestamp
    private Timestamp createdAt;

    // Constructors
    public Event() {}

    public Event(String title, String description, String location, String category, User publisher) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.publisher = publisher;
    }

    // Getters and Setters
}
