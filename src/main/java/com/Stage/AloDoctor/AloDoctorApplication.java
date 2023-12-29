package com.Stage.AloDoctor;

import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.Stage.AloDoctor.models.Appointment;
import com.Stage.AloDoctor.models.Doctor;
import com.Stage.AloDoctor.models.Patient;
import com.Stage.AloDoctor.repositories.AppointmentRepository;
import com.Stage.AloDoctor.repositories.DoctorRepository;
import com.Stage.AloDoctor.repositories.PatientRepository;

@SpringBootApplication
@EntityScan(basePackages = "com.Stage.AloDoctor.models")
public class AloDoctorApplication implements CommandLineRunner {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(AloDoctorApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

   /*
    @Override
    public void run(String... args) throws Exception {
        Doctor doctor1 = new Doctor();
        doctor1.setName("hamim abderrahmane");
        doctor1.setSpecialite("General Medicine");
        doctor1.setCity("casablanca");
        doctor1.setTitle("Dr");
        doctor1.setPhoto("Photo URL");
        doctor1.setActes(new String[]{"Acte3", "Acte4"});
        doctor1.setCabinet(true);
        doctor1.setAdomicile(false);
        doctor1.setVideocall(true);
        doctor1.setAdresse("MABROUKA, casablanca");
        doctor1.setNumtele("0621066733");
        doctor1.setNumcabinet("Cabinet Number");
        doctor1.setEmail("abderahmane.hamim@gmail.com");
        doctor1.setPassword("12345");

        try {
            doctorRepository.save(doctor1);
        } catch (Exception e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }

        System.out.println(doctor1.toString());
        
        Patient patient1 = new Patient();
        patient1.setLastname("Amina");
        patient1.setFirstname("Bartal");
        patient1.setAge("23");
        patient1.setEmail("amina.BARTAL@gmail.com");
        patient1.setPassword("password2");
        patient1.setAdresse("Sample Address");
        patient1.setGender("Female");
        patient1.setPhonenumber("0666666666");
        try {
            patientRepository.save(patient1);
        } catch (Exception e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }

        System.out.println(patient1.toString());
        
        Appointment appointment = new Appointment();
        appointment.setDateappoint(Date.valueOf("2023-05-06")); // Set the appointment date
        appointment.setTimeappoint(Time.valueOf("10:44:00")); // Set the appointment time
        appointment.setAcceptance("accepted"); // Set the acceptance status
        appointment.setDoctor(doctor1);
        appointment.setPatient(patient1);

        // Save the appointment to the database
        appointmentRepository.save(appointment);

        System.out.println("Appointment patient1 avec doctor 1 réussite");
        
    }
    */
}
