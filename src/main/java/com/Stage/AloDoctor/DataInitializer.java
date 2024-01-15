package com.Stage.AloDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Stage.AloDoctor.models.Appointment;
import com.Stage.AloDoctor.models.Doctor;
import com.Stage.AloDoctor.models.Patient;
import com.Stage.AloDoctor.repositories.AppointmentRepository;
import com.Stage.AloDoctor.repositories.DoctorRepository;
import com.Stage.AloDoctor.repositories.PatientRepository;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public void run(String... args) throws Exception {
   
        if (doctorRepository.count() == 0) {
        
            Doctor doctor = new Doctor();
            doctor.setName("Dr. John Doe");
            doctor.setSpecialite("General Medicine");
            doctor.setCity("City");
            doctor.setTitle("Title");
            doctor.setPhoto("Photo URL");
            doctor.setActes(new String[]{"Acte1", "Acte2"});
            doctor.setCabinet(true);
            doctor.setAdomicile(false);
            doctor.setVideocall(true);
            doctor.setAdresse("Doctor's Address");
            doctor.setNumtele("Doctor's Phone Number");
            doctor.setNumcabinet("Cabinet Number");

       
            doctorRepository.save(doctor);

            System.out.println("Doctor added successfully!");
        }
        if (patientRepository.count() == 0) {
            
            Patient patient = new Patient();
            patient.setFirstname("John");
            patient.setLastname("Doe");
            patient.setEmail("john.doe@example.com");
            patient.setPassword("password");
            patient.setAge("30");
            patient.setAdresse("Sample Address");
            patient.setGender("Male");
            patient.setPhonenumber("1234567890");
      
            patientRepository.save(patient);
        }
   
        if (appointmentRepository.count() == 0) {
      
            Doctor doctor = doctorRepository.findAll().iterator().next();
            Patient patient = patientRepository.findAll().iterator().next();

            Appointment appointment = new Appointment();
            appointment.setDateappoint(Date.valueOf("2023-01-01")); 
            appointment.setTimeappoint(LocalTime.of(10, 00,00)); 
            appointment.setAcceptance("Pending"); 
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);

           
            appointmentRepository.save(appointment);

            System.out.println("Appointment added successfully!");
        }
    }
    }
