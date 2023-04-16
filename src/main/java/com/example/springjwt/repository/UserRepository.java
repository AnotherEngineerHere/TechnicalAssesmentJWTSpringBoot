package com.example.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.springjwt.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	  Optional<User> findByMobilePhone(String mobilePhone);

	  Boolean existsByMobilePhone(String mobilePhone);
}
