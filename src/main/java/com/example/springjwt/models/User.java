package com.example.springjwt.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "Usuario")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column(name = "nombre")
	@Getter
	@Setter
	private String nombre;
	

	@NotBlank
	@Column(name = "apellido")
	@Getter
	@Setter
	private String apellido;
	

	@NotBlank
	@Column(name = "fechaDeNacimiento")
	@Getter
	@Setter
	private String fechaDeNacimiento;
	

	@NotBlank
	@Column(name = "direccion")
	@Getter
	@Setter
	private String direccion;
	
	@NotBlank
	@Column(name = "password")
	@Getter
	@Setter
	@JsonIgnore
	private String password;
	
	@NotBlank
	@Column(name = "mobilePhone")
	@Getter
	@Setter
	private String mobilePhone;
	
	
	@Column(name = "correo")
	@Getter
	@Setter
	private String correo;

	public User(String nombre,  String apellido,  String fechaDeNacimiento,
			 String direccion,  String password,  String mobile_phone,
			  String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.direccion = direccion;
		this.password = password;
		this.mobilePhone = mobile_phone;
		this.correo = correo;
	}
	public User() {
		 
		}
	public User(String string,String nombre,  String apellido,  String fechaDeNacimiento,
			 String direccion,  String password,  String mobile_phone,
			  String correo) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.direccion = direccion;
		this.password = password;
		this.mobilePhone = mobile_phone;
		this.correo = correo;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile_phone() {
		return mobilePhone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobilePhone = mobile_phone;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
