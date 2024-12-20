package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private String status; // PENDING, APPROVED, CANCELED, EXPIRED

    public Reservation(Item item, User user, String status, LocalDateTime startAt, LocalDateTime endAt) {
        this.item = item;
        this.user = user;
        this.status = status;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public Reservation() {}

    public void updateStatus(String status) {
        this.status = status;
    }
}
