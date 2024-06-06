package com.example.SWP391.controller;



import com.example.SWP391.entity.EventGallery;
import com.example.SWP391.entity.EventSchedule;

import com.example.SWP391.service.EventGalleryService;
import com.example.SWP391.service.EventScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/event-gallery")
public class EventGalleryController {
    @Autowired
    private EventGalleryService eventGalleryService;

    @GetMapping
    public List<EventGallery> getAllEventGalleries() {
        return eventGalleryService.getAllEventGalleries();
    }

    @GetMapping("/{id}")
    public EventGallery getEventGalleryById(@PathVariable int id) {
        return eventGalleryService.getEventGalleryById(id);
    }

}
