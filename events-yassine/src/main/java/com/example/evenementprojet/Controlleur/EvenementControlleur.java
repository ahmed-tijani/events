package com.example.evenementprojet.Controlleur;

import com.example.evenementprojet.Entities.Evenement;
import com.example.evenementprojet.Service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/Evenement", produces = MediaType.APPLICATION_JSON_VALUE)
public class EvenementControlleur {
    @Autowired
    private EvenementService evenementService;
    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Evenement> createEv(@RequestBody Evenement evenement) {
        return new ResponseEntity<>(evenementService.addEvenement(evenement), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Evenement> updateEv(@PathVariable(value = "id") int id,
                                                   @RequestBody Evenement ev){
        return new ResponseEntity<>(evenementService.UpdateEvenement(id, ev),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteEv(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(evenementService.delateEvenement(id), HttpStatus.OK);
    }
}
