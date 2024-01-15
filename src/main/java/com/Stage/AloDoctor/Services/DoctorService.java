package com.Stage.AloDoctor.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Stage.AloDoctor.models.Appointment;
import com.Stage.AloDoctor.models.Doctor;
@Service
public interface DoctorService {

    List<Doctor> getAllDoctors();
    List<Appointment> getDoctorAppointments(long doctorId);

    Doctor getDoctorById(long id);

    Doctor createDoctor(Doctor doctor);

    Doctor updateDoctor(long id, Doctor doctor);

    void deleteDoctor(long id);
}