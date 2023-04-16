package com.example.springjwt.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjwt.models.User;
import com.example.springjwt.payload.request.SignupRequest;
import com.example.springjwt.payload.response.MessageResponse;
import com.example.springjwt.repository.UserRepository;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/usuarios/")
public class UserController {
	  @Autowired
	  UserRepository userRepository;
	  
	  @Autowired
	  PasswordEncoder encoder;


		@GetMapping (value = "getUser/{id}")
		private ResponseEntity<Optional<User>> getUserByID (@PathVariable ("id") Long id){
			return ResponseEntity.ok(userRepository.findById(id));
		}
		
		@PutMapping("update/{id}")
		public ResponseEntity<MessageResponse> updatePersona(@PathVariable Long id, @RequestBody User usuario) {
		    try {
		        User userToUpdate = userRepository.findById(id).orElseThrow();
		        userToUpdate.setNombre(usuario.getNombre());
		        userToUpdate.setApellido(usuario.getApellido());
		        userToUpdate.setDireccion(usuario.getDireccion());
		        userToUpdate.setCorreo(usuario.getCorreo());

		        if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
		            String encodedPassword = encoder.encode(usuario.getPassword());
		            userToUpdate.setPassword(encodedPassword);
		        }

		        // Guarda los cambios en la base de datos
		        userRepository.saveAndFlush(userToUpdate);

		        return ResponseEntity.ok(new MessageResponse("Usuario actualizado correctamente."));
		    } catch (NoSuchElementException e) {
		        return ResponseEntity.notFound().build();
		    } catch (Exception e) {
		        e.printStackTrace();
		        return ResponseEntity.badRequest().body(new MessageResponse("Error al actualizar el usuario."));
		    }
		}



		
		@DeleteMapping(value = "delete/{id}")
		private ResponseEntity<Boolean> deleteUsuario(@PathVariable("id") Long id) {
		    userRepository.deleteById(id);
		    return ResponseEntity.ok().build();
		}
		@PostMapping("/create")
		  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		    if (userRepository.existsByMobilePhone(signUpRequest.getMobile_phone())) {
		        return ResponseEntity
		            .badRequest()
		            .body(new MessageResponse("Error: Mobile Phone is already taken!"));
		      }
		    User user = new User(signUpRequest.getNombre(), 
		               signUpRequest.getApellido(),
		               signUpRequest.getFechaDeNacimiento(),
		               signUpRequest.getDireccion(),
		               encoder.encode(signUpRequest.getPassword()),
		            		   signUpRequest.getMobile_phone(),
		            		   signUpRequest.getCorreo()
		    	               );

		    userRepository.save(user);
		    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		  }
	 

}
