package com.Stage.AloDoctor.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long idDoctor;

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "password cannot be blank")
    private String password;

    @NotBlank(message = "Specialty cannot be blank")
    private String specialite;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    private String photo;

    @Size(min = 1, message = "At least one act is required")
    private String[] actes;

    @NotNull(message = "Cabinet information is required")
    private Boolean cabinet;

    @NotNull(message = "Adomicile information is required")
    private Boolean adomicile;

    @NotNull(message = "Videocall information is required")
    private Boolean videocall;

    private String adresse;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String numtele;

    private String numcabinet;

    @JsonManagedReference
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
	 
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Doctor(long idDoctor, @NotBlank(message = "Name cannot be blank") String name,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
			@NotBlank(message = "password cannot be blank") String password,
			@NotBlank(message = "Specialty cannot be blank") String specialite,
			@NotBlank(message = "City cannot be blank") String city,
			@NotBlank(message = "Title cannot be blank") String title, String photo,
			@Size(min = 1, message = "At least one act is required") String[] actes,
			@NotNull(message = "Cabinet information is required") Boolean cabinet,
			@NotNull(message = "Adomicile information is required") Boolean adomicile,
			@NotNull(message = "Videocall information is required") Boolean videocall, String adresse,
			@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits") String numtele, String numcabinet,
			List<Appointment> appointments) {
		super();
		this.idDoctor = idDoctor;
		this.name = name;
		this.email = email;
		this.password = password;
		this.specialite = specialite;
		this.city = city;
		this.title = title;
		this.photo = photo;
		this.actes = actes;
		this.cabinet = cabinet;
		this.adomicile = adomicile;
		this.videocall = videocall;
		this.adresse = adresse;
		this.numtele = numtele;
		this.numcabinet = numcabinet;
		this.appointments = appointments;
	}


	/**
	 * @return the idDoctor
	 */
	public long getIdDoctor() {
		return idDoctor;
	}

	/**
	 * @param idDoctor the idDoctor to set
	 */
	public void setIdDoctor(long idDoctor) {
		this.idDoctor = idDoctor;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the specialite
	 */
	public String getSpecialite() {
		return specialite;
	}

	/**
	 * @param specialite the specialite to set
	 */
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the actes
	 */
	public String[] getActes() {
		return actes;
	}

	/**
	 * @param actes the actes to set
	 */
	public void setActes(String[] actes) {
		this.actes = actes;
	}

	/**
	 * @return the cabinet
	 */
	public Boolean getCabinet() {
		return cabinet;
	}

	/**
	 * @param cabinet the cabinet to set
	 */
	public void setCabinet(Boolean cabinet) {
		this.cabinet = cabinet;
	}

	/**
	 * @return the adomicile
	 */
	public Boolean getAdomicile() {
		return adomicile;
	}

	/**
	 * @param adomicile the adomicile to set
	 */
	public void setAdomicile(Boolean adomicile) {
		this.adomicile = adomicile;
	}

	/**
	 * @return the videocall
	 */
	public Boolean getVideocall() {
		return videocall;
	}

	/**
	 * @param videocall the videocall to set
	 */
	public void setVideocall(Boolean videocall) {
		this.videocall = videocall;
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
	 * @return the numtele
	 */
	public String getNumtele() {
		return numtele;
	}

	/**
	 * @param numtele the numtele to set
	 */
	public void setNumtele(String numtele) {
		this.numtele = numtele;
	}

	/**
	 * @return the numcabinet
	 */
	public String getNumcabinet() {
		return numcabinet;
	}

	/**
	 * @param numcabinet the numcabinet to set
	 */
	public void setNumcabinet(String numcabinet) {
		this.numcabinet = numcabinet;
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
		return "Doctor [idDoctor=" + idDoctor + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", specialite=" + specialite + ", city=" + city + ", title=" + title + ", photo=" + photo + ", actes="
				+ Arrays.toString(actes) + ", cabinet=" + cabinet + ", adomicile=" + adomicile + ", videocall="
				+ videocall + ", adresse=" + adresse + ", numtele=" + numtele + ", numcabinet=" + numcabinet
				+ ", appointments=" + appointments + "]";
	}


	
}
