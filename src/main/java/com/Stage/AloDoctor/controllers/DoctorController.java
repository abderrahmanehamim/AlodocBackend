package com.Stage.AloDoctor.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.Stage.AloDoctor.Services.AppointmentService;
import com.Stage.AloDoctor.Services.DoctorService;
import com.Stage.AloDoctor.models.Appointment;
import com.Stage.AloDoctor.models.AppointmentDTO;
import com.Stage.AloDoctor.models.Doctor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null) {
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable long id, @RequestBody Doctor doctor) {
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{doctorId}/appointments")
    public ResponseEntity<List<AppointmentDTO>> getDoctorAppointments(@PathVariable long doctorId) {
        List<Appointment> appointments = doctorService.getDoctorAppointments(doctorId);
        if (appointments != null && !appointments.isEmpty()) {
            List<AppointmentDTO> appointmentDTOs = appointments.stream()
                    .map(appointment -> new AppointmentDTO(
                            appointment.getIdappoint(),
                            appointment.getDateappoint(),
                            appointment.getTimeappoint(),
                            appointment.getAcceptance(),
                      
                            appointment.getPatient()
                    ))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(appointmentDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{doctorId}/appointments/{appointmentId}")
    public ResponseEntity<Appointment> updateAppointmentAcceptance(
            @PathVariable long doctorId, @PathVariable long appointmentId, @RequestBody String acceptance) {
        Appointment updatedAppointment = appointmentService.updateAppointmentAcceptance(appointmentId, acceptance);
        return ResponseEntity.ok(updatedAppointment);
    }
}
