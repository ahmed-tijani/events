package com.example.evenement.Services;

import com.example.evenement.Entities.Reclamation;
import com.example.evenement.Repositories.IReclamationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamationService {

    @Autowired
    private IReclamationRepo reclamationRepo;

    public Reclamation addReclamation (Reclamation reclamation){
        return reclamationRepo.save(reclamation);

    }

    public Reclamation updateCandidat(int id, Reclamation reclamation) {

        if (reclamationRepo.findById(id).isPresent()) {
            Reclamation existingRec = reclamationRepo.findById(id).get();
            existingRec.setNom(reclamation.getNom());
            existingRec.setPrenom(reclamation.getPrenom());
            existingRec.setReclamation(reclamation.getReclamation());
            return reclamationRepo.save(existingRec);
        } else
            return null;
    }
    public String deleteReclamation(int id) {
        if (reclamationRepo.findById(id).isPresent()) {
            reclamationRepo.deleteById(id);
            return "reclamation supprimé";
        } else
            return "reclamation non supprimé";
    }

}
