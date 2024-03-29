package com.Stage.AloDoctor.Services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Stage.AloDoctor.models.Appointment;
import com.Stage.AloDoctor.models.Patient;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient createNewPatient(Patient patient);
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
    List<Appointment> getPatientAppointments(Long patientId);
}