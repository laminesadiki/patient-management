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
        patientRepository.save(new Patient(null,"Ayoub",new Date(),false));
        patientRepository.save(new Patient(null,"Lamine",new Date(),false));
        patientRepository.save(new Patient(null,"Sadiki",new Date(),false));

        patientRepository.findAll().forEach(p -> {
            System.out.println(p.getNom());
        });
    }
}
