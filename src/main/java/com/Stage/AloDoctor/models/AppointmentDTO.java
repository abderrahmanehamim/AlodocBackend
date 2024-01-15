package com.Stage.AloDoctor.models;

import java.sql.Date;
import java.time.LocalTime;

public class AppointmentDTO {

	private Long idappoint;
	    private Date dateappoint;
	    private LocalTime timeappoint;
	    private String acceptance;
	   
	    private Patient patient;

		public AppointmentDTO(Long idappoint, Date dateappoint, LocalTime timeappoint, String acceptance,
				Patient patient) {
			super();
			this.idappoint = idappoint;
			this.dateappoint = dateappoint;
			this.timeappoint = timeappoint;
			this.acceptance = acceptance;
			this.patient = patient;
		}

		public AppointmentDTO() {
			super();
		}
		 /**
		 * @return the idappoint
		 */
		public Long getIdappoint() {
			return idappoint;
		}

		/**
		 * @param idappoint the idappoint to set
		 */
		public void setIdappoint(Long idappoint) {
			this.idappoint = idappoint;
		}

		/**
		 * @return the dateappoint
		 */
		public Date getDateappoint() {
			return dateappoint;
		}

		/**
		 * @param dateappoint the dateappoint to set
		 */
		public void setDateappoint(Date dateappoint) {
			this.dateappoint = dateappoint;
		}

		/**
		 * @return the timeappoint
		 */
		public LocalTime getTimeappoint() {
			return timeappoint;
		}

		/**
		 * @param timeappoint the timeappoint to set
		 */
		public void setTimeappoint(LocalTime timeappoint) {
			this.timeappoint = timeappoint;
		}

		/**
		 * @return the acceptance
		 */
		public String getAcceptance() {
			return acceptance;
		}

		/**
		 * @param acceptance the acceptance to set
		 */
		public void setAcceptance(String acceptance) {
			this.acceptance = acceptance;
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

}
