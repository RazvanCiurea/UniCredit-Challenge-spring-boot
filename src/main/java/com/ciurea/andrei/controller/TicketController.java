package com.ciurea.andrei.controller;

import com.ciurea.andrei.entity.Ticket;
import com.ciurea.andrei.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Andrei on 5/27/2017.
 */
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/buy_ticket", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTicket(@RequestBody Ticket ticket) { ticketService.addTicket(ticket); }

    @RequestMapping(value = "/cancel_ticket", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void removeTicket(@RequestBody Ticket ticket) { ticketService.removeTicket(ticket); }

    @RequestMapping(value = "/ticket_details/{id}", method = RequestMethod.GET)
    public Ticket getTicket(@PathVariable("id") int id){
        return ticketService.getTicket(id);
    }

}
