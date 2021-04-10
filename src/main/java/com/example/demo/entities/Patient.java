package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
//@Table(name = "PATIENTS")
//@Table
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5 ,max = 15,message = "Nom incorrect")
    private String nom;
    @Temporal(TemporalType.DATE) // C'est de JPA
    @DateTimeFormat(pattern = "yyyy-MM-dd") // C'est de Spring
    private Date dateNaissance;
//    private int score;
    private boolean malade;
    @DecimalMin("3")
    private int score;


}

