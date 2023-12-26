package com.Stage.AloDoctor.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "\"user\"") // Enclose the table name in double quotes
public class User implements Serializable {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(unique = true)
	    private String email;

	    private String password;

	    @Enumerated(EnumType.STRING)
	    private UserRole role; // Add this field for user roles (UserRole is an enum you'll define)

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public User(Long id, String email, String password, UserRole role) {
			super();
			this.id = id;
			this.email = email;
			this.password = password;
			this.role = role;
		}

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
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
		 * @return the role
		 */
		public UserRole getRole() {
			return role;
		}

		/**
		 * @param role the role to set
		 */
		public void setRole(UserRole role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + "]";
		}

		
	    
}
