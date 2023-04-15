package com.example.springjwt.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.springjwt.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	
  private static final long serialVersionUID = 1L;


private Long id;

 private String nombre;
  
  private String apellido;

  private String correo;
  
  private String fechaDeNacimiento;

  private String direccion;
  
  private String mobile_phone;
  
  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;
  public UserDetailsImpl(Long id ,String nombre, String apellido, String correo, String fechaDeNacimiento, String direccion,
	String mobile_phone, String password) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.correo = correo;
	this.fechaDeNacimiento = fechaDeNacimiento;
	this.direccion = direccion;
	this.mobile_phone = mobile_phone;
	this.password = password;
}

  public static UserDetailsImpl build(User user) {
    return new UserDetailsImpl(
        user.getId(),
        user.getNombre(),
        user.getApellido(),
        user.getFechaDeNacimiento(),
        user.getDireccion(),
        user.getCorreo(),
        user.getMobile_phone(),
        user.getPassword());
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return correo;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return nombre;
  }

  public String getFechaDeNacimiento() {
	return fechaDeNacimiento;
}


public String getMobile_phone() {
	return mobile_phone;
}

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
}
}
