package com.ciurea.andrei.controller;

import com.ciurea.andrei.entity.Event;
import com.ciurea.andrei.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Andrei on 5/27/2017.
 */
@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/list_events", method = RequestMethod.GET)
    public Collection<Event> getAllEvents() { return eventService.getAllEvents(); }
}
