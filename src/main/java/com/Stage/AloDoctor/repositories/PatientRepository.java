package com.Stage.AloDoctor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Stage.AloDoctor.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}