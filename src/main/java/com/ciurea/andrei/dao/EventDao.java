package com.ciurea.andrei.dao;

import com.ciurea.andrei.entity.Event;

import java.util.Collection;

/**
 * Created by Andrei on 5/27/2017.
 */
public interface EventDao {
    Collection<Event> getAllEvents();
}
