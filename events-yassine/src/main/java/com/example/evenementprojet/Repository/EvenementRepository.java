package com.example.evenementprojet.Repository;

import com.example.evenementprojet.Entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Integer> {

}
