package com.example.SWP391.service;

import com.example.SWP391.entity.EventDetails;
import com.example.SWP391.repository.EventDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventDetailsService {
    @Autowired
    public EventDetailsRepository eventDetailsRepository;

    public List<EventDetails> getAllEventDetails() {
        return eventDetailsRepository.findAll();
    }

    public EventDetails getEventDetailsById(int id) {
        return eventDetailsRepository.findById(id).orElse(null);
    }
}
