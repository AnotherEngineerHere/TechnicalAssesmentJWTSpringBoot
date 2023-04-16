package com.example.springjwt.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjwt.models.User;
import com.example.springjwt.payload.request.LoginRequest;
import com.example.springjwt.payload.request.SignupRequest;
import com.example.springjwt.payload.response.JwtResponse;
import com.example.springjwt.payload.response.MessageResponse;
import com.example.springjwt.repository.UserRepository;
import com.example.springjwt.security.jwt.JwtUtils;
import com.example.springjwt.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;


  @Autowired
  PasswordEncoder encoder;
  
  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getMobile_phone(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    System.out.println("Token: " + jwt);
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    return ResponseEntity.ok(new JwtResponse(jwt));
  }
	@GetMapping(value = "/getAll")
	private ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userRepository.findAll());
	}

  

 
}
