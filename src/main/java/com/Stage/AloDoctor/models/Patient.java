package com.Stage.AloDoctor.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "patient")

public class Patient {
	 @Id
	    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	    private Long idPatient;
  
    private String firstname;


    private String lastname;


    private String email;


    private String password;

   
    private String age;

   
    private String adresse;


    private String gender;

   
    private String phonenumber;
    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "patient",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;



public Patient() {
	super();
	// TODO Auto-generated constructor stub
}








public Patient(Long idPatient, String firstname, String lastname, String email, String password, String age,
		String adresse, String gender, String phonenumber, List<Appointment> appointments) {
	super();
	this.idPatient = idPatient;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.password = password;
	this.age = age;
	this.adresse = adresse;
	this.gender = gender;
	this.phonenumber = phonenumber;
	this.appointments = appointments;
}








/**
 * @return the idpatient
 */
public Long getIdpatient() {
	return idPatient;
}
/**
 * @param idpatient the idpatient to set
 */
public void setIdpatient(Long idpatient) {
	idPatient = idpatient;
}
/**
 * @return the firstname
 */
public String getFirstname() {
	return firstname;
}
/**
 * @param firstname the firstname to set
 */
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
/**
 * @return the lastname
 */
public String getLastname() {
	return lastname;
}
/**
 * @param lastname the lastname to set
 */
public void setLastname(String lastname) {
	this.lastname = lastname;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
/**
 * @return the age
 */
public String getAge() {
	return age;
}
/**
 * @param string the age to set
 */
public void setAge(String string) {
	this.age = string;
}
/**
 * @return the adresse
 */
public String getAdresse() {
	return adresse;
}
/**
 * @param adresse the adresse to set
 */
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
/**
 * @return the gender
 */
public String getGender() {
	return gender;
}
/**
 * @param gender the gender to set
 */
public void setGender(String gender) {
	this.gender = gender;
}
/**
 * @return the phonenumber
 */
public String getPhonenumber() {
	return phonenumber;
}
/**
 * @param phonenumber the phonenumber to set
 */
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
/**
 * @return the appointments
 */
public List<Appointment> getAppointments() {
	return appointments;
}
/**
 * @param appointments the appointments to set
 */
public void setAppointments(List<Appointment> appointments) {
	this.appointments = appointments;
}

@Override
public String toString() {
	return "Patient [Idpatient=" + idPatient + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
			+ email + ", password=" + password + ", age=" + age + ", adresse=" + adresse + ", gender=" + gender
			+ ", phonenumber=" + phonenumber + ", appointments=" + appointments + "]";
}

}
