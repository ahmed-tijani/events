package com.example.evennemntuser.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
@Document(collection = "user")
public class User implements Serializable {
        private static final long serialVersionUID = 6;
        @Id
        @GeneratedValue
        private int id;
        private String nom,prenom,email;


}
