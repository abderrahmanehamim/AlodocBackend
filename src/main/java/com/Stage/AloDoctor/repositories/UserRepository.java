package com.Stage.AloDoctor.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Stage.AloDoctor.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	  Optional<User> findByEmail(String email);

}
