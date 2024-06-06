package com.example.SWP391.controller;

import com.example.SWP391.entity.EventSchedule;
import com.example.SWP391.service.EventScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/event-schedule")
public class EventScheduleController {
    @Autowired
    private EventScheduleService eventScheduleService;

    @GetMapping
    public List<EventSchedule> getAllEventSchedules() {
        return eventScheduleService.getAllEventSchedules();
    }

    @GetMapping("/{id}")
    public EventSchedule getEventScheduleById(@PathVariable int id) {
        return eventScheduleService.getEventScheduleById(id);
    }
}
