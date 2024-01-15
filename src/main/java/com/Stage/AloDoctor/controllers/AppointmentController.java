package com.Stage.AloDoctor.controllers;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Stage.AloDoctor.Services.AppointmentService;
import com.Stage.AloDoctor.models.Appointment;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping("/doctor/{id}")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable Long id) {
        return appointmentService.getAppointmentsByDoctorId(id);
    }

    @GetMapping("/patient/{id}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Long id) {
        return appointmentService.getAppointmentsByPatientId(id);
    }

    @PostMapping
    public Appointment saveAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
    @PostMapping("/schedule")
    public Appointment scheduleAppointment(
            @RequestParam Long patientId,
            @RequestParam Long doctorId,
            @RequestParam String date,
            @RequestParam LocalTime time) {
    	 Date parsedDate = Date.valueOf(date);
        return appointmentService.scheduleAppointment(patientId, doctorId, parsedDate, time);
    }
}
