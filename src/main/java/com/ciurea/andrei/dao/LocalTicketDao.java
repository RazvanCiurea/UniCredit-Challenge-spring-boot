package com.ciurea.andrei.dao;

import com.ciurea.andrei.entity.Ticket;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrei on 5/27/2017.
 */
@Repository
@Qualifier("localTickets")
public class LocalTicketDao implements TicketDao{

    private static Map<Integer, Ticket> tickets;

    static {
        tickets = new HashMap<Integer, Ticket>(){

            {
                put(1, new Ticket(1, 50, "Andrei", "UBIS"));
                put(2, new Ticket(2, 200, "Iulian", "UNTOLD"));
                put(3, new Ticket(3, 0, "Alex", "Antipa"));
            }
        };
    }

    @Override
    public void addTicket(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
    }

    @Override
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket.getId());
    }

    @Override
    public Ticket getTicket(int id) {
        return tickets.get(id);
    }
}
