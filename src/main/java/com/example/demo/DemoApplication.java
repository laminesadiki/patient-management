package com.example.demo;

import com.example.demo.dao.PatientRepository;
import com.example.demo.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"Hassan",new Date(),false,4));
        patientRepository.save(new Patient(null,"Mohamed",new Date(),false,12));
        patientRepository.save(new Patient(null,"Samira",new Date(),true,9));
        patientRepository.save(new Patient(null,"Ahmed",new Date(),false,5));
        patientRepository.save(new Patient(null,"Amine",new Date(),false,32));
        patientRepository.save(new Patient(null,"youssra",new Date(),true,89));
        patientRepository.save(new Patient(null,"Sawsan",new Date(),false,45));
        patientRepository.save(new Patient(null,"Kawtar",new Date(),false,62));
        patientRepository.save(new Patient(null,"Nissrine",new Date(),true,19));

        patientRepository.findAll().forEach(p -> {
            System.out.println(p.getNom());
        });
    }
}
