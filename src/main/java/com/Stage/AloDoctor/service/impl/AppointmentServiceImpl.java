package com.Stage.AloDoctor.service.impl;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Stage.AloDoctor.Services.AppointmentService;
import com.Stage.AloDoctor.models.Appointment;
import com.Stage.AloDoctor.models.Doctor;
import com.Stage.AloDoctor.models.Patient;
import com.Stage.AloDoctor.repositories.AppointmentRepository;
import com.Stage.AloDoctor.repositories.DoctorRepository;
import com.Stage.AloDoctor.repositories.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired 
    private PatientRepository patientRepository;

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

        System.out.println("Before Update - Acceptance: " + appointment.getAcceptance());
        appointment.setAcceptance(acceptance);
        System.out.println("After Update - Acceptance: " + appointment.getAcceptance());
        return appointmentRepository.save(appointment);
    }

	@Override
	public Appointment scheduleAppointment(Long patientId, Long doctorId, Date date, LocalTime time) {
		Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id " + patientId));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id " + doctorId));
        Appointment appointment = new Appointment();
        appointment.setDateappoint(date);
        appointment.setTimeappoint(time);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        
		return appointmentRepository.save(appointment);
	}
}
