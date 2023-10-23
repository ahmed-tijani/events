package com.example.evenementprojet.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Getter
@Setter
@Document(collection = "evenement")
public class Evenement implements Serializable {
    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue
    int id;

    String nomEvenement , emplacement , type ;
    int nombreParticipent;

}
