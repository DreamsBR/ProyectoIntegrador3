package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="empleado")
public class empleado {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id_emp ;
	@Column
	private String nom_emp ;
	@Column
	private String apell_emp ;
	@Column
	private String dni_emp ;
	@Column
	private String fech_emp ;
	@Column
	private String direc_emp ;
	@Column
	private String email_emp ;
	@Column
	private String telef_emp ;
	@Column
	private int id_cargo;
	@Column
	private String estado_emp ;
	
	public int getId_emp() {
		return id_emp;
	}
	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}
	public String getNom_emp() {
		return nom_emp;
	}
	public void setNom_emp(String nom_emp) {
		this.nom_emp = nom_emp;
	}
	public String getApell_emp() {
		return apell_emp;
	}
	public void setApell_emp(String apell_emp) {
		this.apell_emp = apell_emp;
	}
	public String getDni_emp() {
		return dni_emp;
	}
	public void setDni_emp(String dni_emp) {
		this.dni_emp = dni_emp;
	}
	public String getFech_emp() {
		return fech_emp;
	}
	public void setFech_emp(String fech_emp) {
		this.fech_emp = fech_emp;
	}
	public String getDirec_emp() {
		return direc_emp;
	}
	public void setDirec_emp(String direc_emp) {
		this.direc_emp = direc_emp;
	}
	public String getEmail_emp() {
		return email_emp;
	}
	public void setEmail_emp(String email_emp) {
		this.email_emp = email_emp;
	}
	public String getTelef_emp() {
		return telef_emp;
	}
	public void setTelef_emp(String telef_emp) {
		this.telef_emp = telef_emp;
	}
	public int getId_cargo() {
		return id_cargo;
	}
	public void setId_cargo(int id_cargo) {
		this.id_cargo = id_cargo;
	}
	public String getEstado_emp() {
		return estado_emp;
	}
	public void setEstado_emp(String estado_emp) {
		this.estado_emp = estado_emp;
	}
	
	
}
