package com.Stage.AloDoctor.models;

import java.sql.Date;
import java.time.LocalTime;

public class AppointmentResponse {

	private Long idappoint;
	    private Date dateappoint;
	    private LocalTime timeappoint;
	    private String acceptance;
	    private Doctor doctor;
		public AppointmentResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AppointmentResponse(Long idappoint, Date dateappoint, LocalTime timeappoint, String acceptance,
				Doctor doctor) {
			super();
			this.idappoint = idappoint;
			this.dateappoint = dateappoint;
			this.timeappoint = timeappoint;
			this.acceptance = acceptance;
			this.doctor = doctor;
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
}
