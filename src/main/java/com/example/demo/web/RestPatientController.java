package com.example.demo.web;

import com.example.demo.dao.PatientRepository;
import com.example.demo.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class RestPatientController {
    @Autowired
    private PatientRepository patientRepository;


    @GetMapping("/restlistPatients")
    public List<Patient> list(){
        return patientRepository.findAll();
    }

    @GetMapping("/restPatients/{id}")
    public Patient getOne(@PathVariable Long id){
        return patientRepository.findById(id).get();
    }




}
