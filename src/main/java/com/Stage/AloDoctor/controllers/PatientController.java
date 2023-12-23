package com.Stage.AloDoctor.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.Stage.AloDoctor.Services.PatientService;
import com.Stage.AloDoctor.models.Patient;

//PatientController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

 @Autowired
 private PatientService patientService;

 @GetMapping
 public List<Patient> getAllPatients() {
     return patientService.getAllPatients();
 }

 @GetMapping("/{id}")
 public Patient getPatientById(@PathVariable Long id) {
     return patientService.getPatientById(id);
 }

 @PostMapping
 public Patient createNewPatient(@RequestBody Patient patient) {
     return patientService.createNewPatient(patient);
 }

 @PutMapping("/{id}")
 public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
     return patientService.updatePatient(id, patient);
 }

 @DeleteMapping("/{id}")
 public void deletePatient(@PathVariable Long id) {
     patientService.deletePatient(id);
 }
}

