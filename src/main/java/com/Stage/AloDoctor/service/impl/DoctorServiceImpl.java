package com.Stage.AloDoctor.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Stage.AloDoctor.Services.DoctorService;
import com.Stage.AloDoctor.models.Appointment;
import com.Stage.AloDoctor.models.Doctor;
import com.Stage.AloDoctor.repositories.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
    
    private static final Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        return optionalDoctor.orElse(null);
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        logger.info("Creating a new doctor: {}", doctor);
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(long id, Doctor doctor) {
        logger.info("Updating doctor with id {}: {}", id, doctor);
        Optional<Doctor> optionalExistingDoctor = doctorRepository.findById(id);
        if (optionalExistingDoctor.isPresent()) {
            Doctor existingDoctor = optionalExistingDoctor.get();
           
            existingDoctor.setName(doctor.getName());
            existingDoctor.setSpecialite(doctor.getSpecialite());
            existingDoctor.setCity(doctor.getCity());
            existingDoctor.setTitle(doctor.getTitle());
            existingDoctor.setPhoto(doctor.getPhoto());
            existingDoctor.setActes(doctor.getActes());
            existingDoctor.setCabinet(doctor.getCabinet());
            existingDoctor.setAdomicile(doctor.getAdomicile());
            existingDoctor.setVideocall(doctor.getVideocall());
            existingDoctor.setAdresse(doctor.getAdresse());
            existingDoctor.setNumtele(doctor.getNumtele());
            existingDoctor.setNumcabinet(doctor.getNumcabinet());
            return doctorRepository.save(existingDoctor);
        } else {
            logger.warn("Doctor with id {} not found.", id);
            return null;
        }
    }

    @Override
    public void deleteDoctor(long id) {
        logger.info("Deleting doctor with id {}", id);
        doctorRepository.deleteById(id);
    }

    @Override
    public List<Appointment> getDoctorAppointments(long doctorId) {
        logger.info("Fetching appointments for doctor with id {}", doctorId);
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            return doctor.getAppointments();
        } else {
            logger.warn("Doctor with id {} not found.", doctorId);
            return null;
        }
    }
    
    public void showDoctors() {
        logger.info("List of Doctors:");
        doctorRepository.findAll().forEach(doctor -> logger.info(doctor.toString()));
    }
}
