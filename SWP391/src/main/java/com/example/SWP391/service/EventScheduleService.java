package com.example.SWP391.service;

import com.example.SWP391.entity.EventSchedule;
import com.example.SWP391.repository.EventScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventScheduleService {
    @Autowired
    private EventScheduleRepository eventScheduleRepository;

    public List<EventSchedule> getAllEventSchedules() {
        return eventScheduleRepository.findAll();
    }

    public EventSchedule getEventScheduleById(int id) {
        return eventScheduleRepository.findById(id).orElse(null);
    }
}
