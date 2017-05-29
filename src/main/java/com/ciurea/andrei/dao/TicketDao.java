package com.ciurea.andrei.dao;

import com.ciurea.andrei.entity.Ticket;

/**
 * Created by Andrei on 5/27/2017.
 */
public interface TicketDao {
    void addTicket(Ticket ticket);
    void removeTicket(Ticket ticket);
    Ticket getTicket(int id);
}
