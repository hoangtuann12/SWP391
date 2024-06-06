package com.example.SWP391.service;

import com.example.SWP391.entity.EventGallery;
import com.example.SWP391.repository.EventGalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventGalleryService {
    @Autowired
    private EventGalleryRepository eventGalleryRepository;

    public List<EventGallery> getAllEventGalleries() {
        return eventGalleryRepository.findAll();
    }

    public EventGallery getEventGalleryById(int id) {
        return eventGalleryRepository.findById(id).orElse(null);
    }
}
