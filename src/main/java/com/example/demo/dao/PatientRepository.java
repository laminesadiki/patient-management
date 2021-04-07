package com.example.demo.dao;

import com.example.demo.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    public Page<Patient> findByNomContains(String mc, Pageable pageable);

}
