package com.example.springjwt.payload.request;

import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class SignupRequest {


	@NotBlank
	@Column(name = "nombre")
	private String nombre;
	
	@NotBlank
	@Column(name = "apellido")
	private String apellido;
	

	@NotBlank
	@Column(name = "fechaDeNacimiento")
	private String fechaDeNacimiento;
	

	@NotBlank
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "token")
	private String token;
	
	@NotBlank
	@Column(name = "password")
	private String password;
	
	@NotBlank
	@Column(name = "mobile_phone")
	private String mobile_phone;
	

	@NotBlank
	@Column(name = "correo")
	private String correo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	  public String getPassword() {
	    return password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }
}
