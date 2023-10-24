package com.example.evenement.Entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter



public class Reclamation implements Serializable {
    @Id
    @GeneratedValue

    private int id;
    private String nom;
    private String prenom;
    private String reclamation;


}
