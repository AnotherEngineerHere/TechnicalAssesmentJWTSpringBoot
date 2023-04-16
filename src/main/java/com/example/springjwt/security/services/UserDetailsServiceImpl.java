package com.example.springjwt.security.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springjwt.models.User;
import com.example.springjwt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  
@Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String mobile_phone) throws UsernameNotFoundException {
    User user = userRepository.findByMobilePhone(mobile_phone)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with mobilePhone: " + mobile_phone));

    return UserDetailsImpl.build(user);
  }
	public User update(User usuario) {
	    Optional<User> optionalUsuario = userRepository.findById(usuario.getId());
	    if (optionalUsuario.isPresent()) {
	    	User usuarioExistente = optionalUsuario.get();
	        usuarioExistente.setNombre(usuario.getNombre());
	        usuarioExistente.setApellido(usuario.getApellido());
	        usuarioExistente.setFechaDeNacimiento(usuario.getFechaDeNacimiento());
	        usuarioExistente.setDireccion(usuario.getDireccion());
	        usuarioExistente.setPassword(usuario.getPassword());
	        usuarioExistente.setMobile_phone(usuario.getMobile_phone());
	        usuarioExistente.setCorreo(usuario.getCorreo());
	        return userRepository.save(usuarioExistente);
	    } else {
	        throw new NoSuchElementException("El usuario con id " + usuario.getId() + " no existe.");
	    }
	}

}
