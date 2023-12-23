package com.Stage.AloDoctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Stage.AloDoctor.Services.AppointmentService;
import com.Stage.AloDoctor.models.Appointment;
import com.Stage.AloDoctor.repositories.AppointmentRepository;
@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
    @Override
    public List<Appointment> getAppointmentsByDoctorId(Long id) {
        return appointmentRepository.findByDoctorId(id);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(Long id) {
        return appointmentRepository.findByPatientId(id);
    }
    @Override
    public Appointment updateAppointmentAcceptance(long appointmentId, String acceptance) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id " + appointmentId));
        appointment.setAcceptance(acceptance);
        return appointmentRepository.save(appointment);
    }
}
