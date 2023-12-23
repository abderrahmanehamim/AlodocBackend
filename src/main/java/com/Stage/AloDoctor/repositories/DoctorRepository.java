package com.Stage.AloDoctor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.Stage.AloDoctor.models.Doctor;
@RepositoryRestController
@RepositoryEventHandler
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
