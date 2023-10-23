package com.example.evenement.Controller;

import com.example.evenement.Entities.Reclamation;
import com.example.evenement.Services.ReclamationService;
import javafx.scene.media.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
public class ReclamationController {

    @Autowired
    ReclamationService reclamationService;
    private String title="Hello i'm the condidate Ahmed Belkahia";
    @RequestMapping("/hello")
    public String SayHello(){
        System.out.println(title);
        return title;
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reclamation> createReclamation(@RequestBody Reclamation reclamation) {
        return new ResponseEntity<>(reclamationService.addReclamation(reclamation), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable(value = "id") int id,
                                                   @RequestBody Reclamation reclamation){
        return new ResponseEntity<>(reclamationService.updateCandidat(id, reclamation),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteReclamation(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(reclamationService.deleteReclamation(id), HttpStatus.OK);
    }

}
