package com.example.evenement.controller;

import com.example.evenement.entities.Ticket;
import com.example.evenement.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Ticket> createCandidat(@RequestBody Ticket ticket) {
        return new ResponseEntity<>(ticketService.addTicket(ticket), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Ticket> updateCandidat(@PathVariable(value = "id") int id,
                                               @RequestBody Ticket ticket)
    {
        return new ResponseEntity<>(ticketService.updateTicket(id, ticket), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(ticketService.deleteTicket(id), HttpStatus.OK);
    }
}
