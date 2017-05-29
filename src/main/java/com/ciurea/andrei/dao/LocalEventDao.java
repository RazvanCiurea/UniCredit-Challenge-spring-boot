package com.ciurea.andrei.dao;

import com.ciurea.andrei.entity.Event;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrei on 5/27/2017.
 */
@Repository
@Qualifier("localEvents")
public class LocalEventDao implements EventDao{

    private static Map<Integer, Event> events;

    static {

        events = new HashMap<Integer, Event>(){

            {
                put(1, new Event(1, "UBIS", "Bucharest", "20/06/2017"));
                put(2, new Event(2, "Antipa", "Bucharest", "22/06/2017"));
            }
        };
    }


    @Override
    public Collection<Event> getAllEvents() {
        return events.values();
    }
}
