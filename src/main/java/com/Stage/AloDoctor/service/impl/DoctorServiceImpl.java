package com.Stage.AloDoctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Stage.AloDoctor.Services.DoctorService;
import com.Stage.AloDoctor.models.Appointment;
import com.Stage.AloDoctor.models.Doctor;
import com.Stage.AloDoctor.repositories.DoctorRepository;
@Service
public class DoctorServiceImpl implements DoctorService{
	   @Autowired
	    private DoctorRepository doctorRepository;

	    @Override
	    public List<Doctor> getAllDoctors() {
	        return doctorRepository.findAll();
	    }

	    @Override
	    public Doctor getDoctorById(long id) {
	        return doctorRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Doctor createDoctor(Doctor doctor) {
	        return doctorRepository.save(doctor);
	    }

	    @Override
	    public Doctor updateDoctor(long id, Doctor doctor) {
	        Doctor existingDoctor = doctorRepository.findById(id).orElse(null);
	        if (existingDoctor != null) {
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
	        }
	        return null;
	    }

	    @Override
	    public void deleteDoctor(long id) {
	        doctorRepository.deleteById(id);
	    }

		@Override
		public List<Appointment> getAppointments(long doctorId) {
			// TODO Auto-generated method stub
			return null;
		}
}
