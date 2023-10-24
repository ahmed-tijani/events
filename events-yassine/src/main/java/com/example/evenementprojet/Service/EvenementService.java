package com.example.evenementprojet.Service;

import com.example.evenementprojet.Entities.Evenement;
import com.example.evenementprojet.Repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvenementService {
    @Autowired
    private EvenementRepository evenementRepository;

    public Evenement addEvenement(Evenement e){return evenementRepository.save(e);}
    public Evenement UpdateEvenement(int id , Evenement e){
        if(evenementRepository.findById(id).isPresent()){
            Evenement evenement=evenementRepository.findById(id).get();
            evenement.setNomEvenement(e.getNomEvenement());
            evenement.setEmplacement(e.getEmplacement());
            evenement.setType(e.getType());
            evenement.setNombreParticipent(e.getNombreParticipent());
            return evenementRepository.save(evenement);

        }
        else return null;
    }
    public String delateEvenement(int id){
        if(evenementRepository.findById(id).isPresent()){
            evenementRepository.deleteById(id);
            return "Evenement supprimé";
        } else
            return "Evenement non supprimé";
    }
}
