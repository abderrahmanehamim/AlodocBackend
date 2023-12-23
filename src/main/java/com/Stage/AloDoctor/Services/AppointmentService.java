package com.Stage.AloDoctor.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Stage.AloDoctor.models.Appointment;
@Service
public interface AppointmentService {
	  List<Appointment> getAllAppointments();

	    Appointment getAppointmentById(Long id);

	    Appointment createAppointment(Appointment appointment);

	    Appointment updateAppointment(Appointment appointment);

	    void deleteAppointment(Long id);
	    List<Appointment> getAppointmentsByDoctorId(Long id);
	    List<Appointment> getAppointmentsByPatientId(Long id);
	    Appointment updateAppointmentAcceptance(long appointmentId, String acceptance);
}
