package com.example.evenement.service;

import com.example.evenement.entities.Ticket;
import com.example.evenement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {
    @Autowired
    TicketRepository ticketRepository;

    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(int id, Ticket newUser) {
        if (ticketRepository.findById(id).isPresent()) {
            Ticket existingCandidat = ticketRepository.findById(id).get();
            existingCandidat.setNom(newUser.getNom());
            existingCandidat.setPrenom(newUser.getPrenom());
            existingCandidat.setEmail(newUser.getEmail());
            return ticketRepository.save(existingCandidat);
        } else
            return null;
    }

    public String deleteTicket(int id) {
        if (ticketRepository.findById(id).isPresent()) {
            ticketRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }
}
