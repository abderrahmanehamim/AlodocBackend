package com.Stage.AloDoctor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Stage.AloDoctor.models.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAll();

    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :idDoctor")
    List<Appointment> findByDoctorId(@Param("idDoctor") Long idDoctor);

    @Query("SELECT a FROM Appointment a WHERE a.patient.id = :idPatient")
    List<Appointment> findByPatientId(@Param("idPatient") Long idPatient);
}
