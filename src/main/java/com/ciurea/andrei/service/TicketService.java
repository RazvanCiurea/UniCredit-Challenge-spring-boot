package com.ciurea.andrei.service;

import com.ciurea.andrei.dao.TicketDao;
import com.ciurea.andrei.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Andrei on 5/27/2017.
 */
@Service
public class TicketService {
    @Autowired
    @Qualifier("mysqlTickets")
    private TicketDao ticketDao;

    public void addTicket(Ticket ticket) { ticketDao.addTicket(ticket); }
    public void removeTicket(Ticket ticket) { ticketDao.removeTicket(ticket); }
    public Ticket getTicket(int id) { return ticketDao.getTicket(id); }
}
