package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "PATIENTS")
//@Table
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "NOM",length = 25)
    private String nom;
//    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
//    private int score;
    private boolean malade;


}

