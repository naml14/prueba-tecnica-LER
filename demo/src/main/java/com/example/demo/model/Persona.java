package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Configuración para crear tabla en PostgreSQL
@Entity
@Table(name = "persona")
public class Persona {
  @Id // Especificación del ID para la tabla
  private Long cedula;
  private String nombre;
  private String apellido;
  private Date fechaNacimiento;

  public Persona() {
  }

  public Persona(Long cedula, String nombre, String apellido, Date fechaNacimiento) {
    this.cedula = cedula;
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
  }

  public Long getCedula() {
    return this.cedula;
  }

  public void setCedula(Long cedula) {
    this.cedula = cedula;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return this.apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public Date getFechaNacimiento() {
    return this.fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

}
