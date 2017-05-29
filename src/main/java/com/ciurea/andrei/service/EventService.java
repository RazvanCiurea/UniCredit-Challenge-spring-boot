package com.ciurea.andrei.service;

import com.ciurea.andrei.dao.EventDao;
import com.ciurea.andrei.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Andrei on 5/27/2017.
 */
@Service
public class EventService {
    @Autowired
    @Qualifier("mysqlEvents")
    private EventDao eventDao;

    public Collection<Event> getAllEvents() { return eventDao.getAllEvents(); }
}
