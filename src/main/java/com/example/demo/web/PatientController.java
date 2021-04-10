package com.example.demo.web;

import com.example.demo.dao.PatientRepository;
import com.example.demo.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
           @RequestParam(name = "size",defaultValue = "5") int size,
           @RequestParam(name="keyword",defaultValue = "") String mc){
//        Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(page, size));
        Page<Patient> pagePatients = patientRepository.findByNomContains(mc,PageRequest.of(page, size));
        model.addAttribute("patients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",mc);
        model.addAttribute("size",size);
        return "patients";
    }

    @GetMapping(path = "/deletePatient")
    public String delete(Long id){
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }

    @GetMapping(path = "/deletePatient1")
    public String delete1(Long id,String keyword,int page,int size){
        patientRepository.deleteById(id);
        return "redirect:/patients?page="+page+"&size="+size+"&keyword="+keyword;
    }

    @GetMapping(path = "/deletePatient2")
    public String delete2(Model model,Long id,int page , int size , String keyword){
        patientRepository.deleteById(id);
        return listPatients(model,page,size,keyword);
    }

    @GetMapping(path = "/formPatient")
    public String formPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatient";
    }

    @PostMapping(path = "/savePatient")
    public String savePatient(@Valid Patient  patient, BindingResult bindingResult){
        if(bindingResult.hasErrors()){return "formPatient";}
        patientRepository.save(patient);
        return "formPatient";
    }




}
