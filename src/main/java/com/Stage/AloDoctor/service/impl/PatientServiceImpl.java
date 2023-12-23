package com.Stage.AloDoctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Stage.AloDoctor.Services.PatientService;
import com.Stage.AloDoctor.models.Patient;
import com.Stage.AloDoctor.repositories.PatientRepository;
@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient createNewPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        Patient existingPatient = patientRepository.findById(id).orElse(null);
        if (existingPatient != null) {
            existingPatient.setFirstname(patient.getFirstname());
            existingPatient.setLastname(patient.getLastname());
            existingPatient.setEmail(patient.getEmail());
            existingPatient.setPassword(patient.getPassword());
            existingPatient.setAge(patient.getAge());
            existingPatient.setAdresse(patient.getAdresse());
            existingPatient.setGender(patient.getGender());
            existingPatient.setPhonenumber(patient.getPhonenumber());
            existingPatient.setAppointments(patient.getAppointments());
        }
        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}
