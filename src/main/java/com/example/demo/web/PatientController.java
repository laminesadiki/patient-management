package com.example.demo.web;

import com.example.demo.dao.PatientRepository;
import com.example.demo.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String index(){
        return "index";
    }

    @GetMapping(path = "/patients")
    public String listPatients(Model model,
           @RequestParam(name="page",defaultValue = "0") int page ,
           @RequestParam(name = "size",defaultValue = "5") int size){
        Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("patients",pagePatients.getContent());
        return "patients";
    }

}
