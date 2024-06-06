package com.example.SWP391.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity(name = "event_schedule")
public class EventSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "schedule_details")
    private String scheduleDetails;
    @Column(name = "actor")

    private String actor;
    @Column(name = "date")

    private LocalDate date;
    @Column(name = "time")

    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "event_details_id")
    private EventDetails eventDetails;

}
