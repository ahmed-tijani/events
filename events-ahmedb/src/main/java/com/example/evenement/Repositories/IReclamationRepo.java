package com.example.evenement.Repositories;

import com.example.evenement.Entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReclamationRepo extends JpaRepository<Reclamation,Integer> {
}
