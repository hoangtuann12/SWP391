package com.example.SWP391.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.bytecode.enhance.spi.EnhancementInfo;

import java.time.LocalTime;

@Data
@Entity(name ="event_details")
public class EventDetails {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="name")
    private String name;
    @Column(name ="description")
    private String description;
    @Column(name ="image")
    private String image;
    @Column(name ="location")
    private String location;
    @Column(name ="duration")
    private LocalTime duration;
    @Column(name ="client")
    private String client;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


}
