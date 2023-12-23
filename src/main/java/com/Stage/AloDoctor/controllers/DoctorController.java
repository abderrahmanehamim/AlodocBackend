package com.Stage.AloDoctor.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Stage.AloDoctor.Services.AppointmentService;
import com.Stage.AloDoctor.Services.DoctorService;
import com.Stage.AloDoctor.models.Appointment;
import com.Stage.AloDoctor.models.Doctor;


@Service
@RestController
public class DoctorController {
	@Autowired
    private DoctorService doctorService;
	@Autowired
	private AppointmentService appointmentservice;

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable long id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping("/doctors")
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @PutMapping("/doctors/{id}")
    public Doctor updateDoctor(@PathVariable long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable long id) {
        doctorService.deleteDoctor(id);
    }
    @GetMapping("/{doctorId}/appointments")
    public List<Appointment> getDoctorAppointments(@PathVariable long doctorId) {
        return doctorService.getAppointments(doctorId);
    }
    @PutMapping("/doctors/{doctorId}/appointments/{appointmentId}")
    public Appointment updateAppointmentAcceptance(@PathVariable long doctorId, @PathVariable long appointmentId, @RequestBody String acceptance) {
        return appointmentservice.updateAppointmentAcceptance(appointmentId, acceptance);
    }
}
