package com.Stage.AloDoctor.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.Stage.AloDoctor.Services.AppointmentService;
import com.Stage.AloDoctor.Services.PatientService;
import com.Stage.AloDoctor.models.Appointment;
import com.Stage.AloDoctor.models.AppointmentResponse;
import com.Stage.AloDoctor.models.Patient;

//PatientController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/patients")
public class PatientController {

 @Autowired
 private PatientService patientService;
 @Autowired
 private AppointmentService appointmentService;

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
 public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
     patientService.deletePatient(id);
     return ResponseEntity.noContent().build();
 }
 
 @PostMapping("/{patientId}/appointments")
 public ResponseEntity<Appointment> createAppointment(
         @PathVariable Long patientId, @RequestBody Appointment appointment) {
     Patient patient = patientService.getPatientById(patientId);
     if (patient != null) {
         appointment.setPatient(patient);
         Appointment createdAppointment = appointmentService.createAppointment(appointment);
         patient.getAppointments().add(createdAppointment);
         patientService.updatePatient(patientId, patient);
         return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
     } else {
         return ResponseEntity.notFound().build();
     }
 }
 @GetMapping("/{id}/appointments")
 public ResponseEntity<List<AppointmentResponse>> getPatientAppointments(@PathVariable Long id) {
     Patient patient = patientService.getPatientById(id);
     if (patient != null) {
    	 List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(id);
        
         List<AppointmentResponse> responseAppointments = appointments.stream()
                 .map(appointment -> new AppointmentResponse(
                      appointment.getIdappoint(),
                      appointment.getDateappoint(),
                      appointment.getTimeappoint(),
                      appointment.getAcceptance(),
                      appointment.getDoctor()
                 ))
                 .collect(Collectors.toList());
         return ResponseEntity.ok(responseAppointments);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

}

