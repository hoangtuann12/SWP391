package com.example.SWP391.controller;


import com.example.SWP391.entity.EventDetails;
import com.example.SWP391.service.EventDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/event-details")
public class EventDetailsController {

    @Autowired
    private EventDetailsService eventDetailsService;

    @GetMapping
    public List<EventDetails> getAllEventDetails() {
        return eventDetailsService.getAllEventDetails();
    }

    @GetMapping("/{id}")
    public EventDetails getEventDetailsById(@PathVariable int id) {
        return eventDetailsService.getEventDetailsById(id);
    }
}
