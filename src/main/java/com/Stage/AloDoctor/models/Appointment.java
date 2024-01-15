package com.Stage.AloDoctor.models;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
private Long Idappoint;
private Date Dateappoint;
private LocalTime Timeappoint;
private String acceptance;
@JsonIgnore
@JsonBackReference
@ManyToOne
@JoinColumn(name = "idDoctor")
private Doctor doctor;
@JsonIgnore
@JsonBackReference
@ManyToOne
@JoinColumn(name = "idPatient")
private Patient patient;

public Appointment(Long idappoint, Date dateappoint, LocalTime timeappoint, String acceptance, Doctor doctor,
		Patient patient) {
	super();
	Idappoint = idappoint;
	Dateappoint = dateappoint;
	Timeappoint = timeappoint;
	this.acceptance = acceptance;
	this.doctor = doctor;
	this.patient = patient;
}
public Appointment() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * @return the idappoint
 */
public Long getIdappoint() {
	return Idappoint;
}
/**
 * @param idappoint the idappoint to set
 */
public void setIdappoint(Long idappoint) {
	Idappoint = idappoint;
}
/**
 * @return the dateappoint
 */
public Date getDateappoint() {
	return Dateappoint;
}
/**
 * @param dateappoint the dateappoint to set
 */
public void setDateappoint(Date dateappoint) {
	Dateappoint = dateappoint;
}
/**
 * @return the timeappoint
 */
public LocalTime getTimeappoint() {
	return Timeappoint;
}
/**
 * @param timeappoint the timeappoint to set
 */
public void setTimeappoint(LocalTime timeappoint) {
	Timeappoint = timeappoint;
}
/**
 * @return the doctor
 */
public Doctor getDoctor() {
	return doctor;
}
/**
 * @param doctor the doctor to set
 */
public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}
/**
 * @return the patient
 */
public Patient getPatient() {
	return patient;
}
/**
 * @param patient the patient to set
 */
public void setPatient(Patient patient) {
	this.patient = patient;
}
@Override
public String toString() {
	return "Appointment [Idappoint=" + Idappoint + ", Dateappoint=" + Dateappoint + ", Timeappoint=" + Timeappoint
			+ ", doctor=" + doctor + ", patient=" + patient + "]";
}
public String getAcceptance() {
	return acceptance;
}
public void setAcceptance(String acceptance) {
	this.acceptance = acceptance;
}

}
