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
        // Check if the doctor is already in the database
        if (doctorRepository.count() == 0) {
            // If not, add a new doctor
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

            // Save the doctor to the database
            doctorRepository.save(doctor);

            System.out.println("Doctor added successfully!");
        }
        if (patientRepository.count() == 0) {
            // Add a sample patient
            Patient patient = new Patient();
            patient.setFirstname("John");
            patient.setLastname("Doe");
            patient.setEmail("john.doe@example.com");
            patient.setPassword("password");
            patient.setAge("30");
            patient.setAdresse("Sample Address");
            patient.setGender("Male");
            patient.setPhonenumber("1234567890");
            // Set other properties as needed
            patientRepository.save(patient);
        }
        // Check if an appointment already exists
        if (appointmentRepository.count() == 0) {
            // Get the doctor and patient from the database
            Doctor doctor = doctorRepository.findAll().iterator().next();
            Patient patient = patientRepository.findAll().iterator().next();

            // Create a new appointment
            Appointment appointment = new Appointment();
            appointment.setDateappoint(Date.valueOf("2023-01-01")); // Set the appointment date
            appointment.setTimeappoint(Time.valueOf("10:00:00")); // Set the appointment time
            appointment.setAcceptance("Pending"); // Set the acceptance status
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);

            // Save the appointment to the database
            appointmentRepository.save(appointment);

            System.out.println("Appointment added successfully!");
        }
    }
    }
