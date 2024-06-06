package com.example.SWP391.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "event_gallery")
public class EventGallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "captivating_image")
    private String captivatingImage;
    @Column(name = "poster_image")
    private String posterImage;

    @ManyToOne
    @JoinColumn(name = "event_details_id")
    private EventDetails eventDetails;
}
