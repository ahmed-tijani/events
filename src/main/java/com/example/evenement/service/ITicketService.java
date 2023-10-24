package com.example.evenement.service;

import com.example.evenement.entities.Ticket;

public interface ITicketService {
    Ticket addTicket(Ticket ticket);
    Ticket updateTicket(int id, Ticket newUser);
    String deleteTicket(int id);
}
