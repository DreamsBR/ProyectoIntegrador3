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
@Table(name="chofer")
public class chofer {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id_chofer;
	@Column
	private String nomb_chof ;
	@Column
	private String apell_chof ;
	@Column
	private String dni_chofer ;
	@Column
	private String sexo_chof ;
	@Column
	private String direc_chof ;
	@Column
	private String telef_chof ;
	@Column
	private String email_chof ;
	@Column
	private String n_brevete  ;
	@Column 
	private int id_vehiculo;
	
	
	
	public int getId_vehiculo() {
		return id_vehiculo;
	}
	public void setId_vehiculo(int id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}
	public int getId_chofer() {
		return id_chofer;
	}
	public void setId_chofer(int id_chofer) {
		this.id_chofer = id_chofer;
	}
	public String getNomb_chof() {
		return nomb_chof;
	}
	public void setNomb_chof(String nomb_chof) {
		this.nomb_chof = nomb_chof;
	}
	public String getApell_chof() {
		return apell_chof;
	}
	public void setApell_chof(String apell_chof) {
		this.apell_chof = apell_chof;
	}
	public String getDni_chofer() {
		return dni_chofer;
	}
	public void setDni_chofer(String dni_chofer) {
		this.dni_chofer = dni_chofer;
	}
	public String getSexo_chof() {
		return sexo_chof;
	}
	public void setSexo_chof(String sexo_chof) {
		this.sexo_chof = sexo_chof;
	}
	public String getDirec_chof() {
		return direc_chof;
	}
	public void setDirec_chof(String direc_chof) {
		this.direc_chof = direc_chof;
	}
	public String getTelef_chof() {
		return telef_chof;
	}
	public void setTelef_chof(String telef_chof) {
		this.telef_chof = telef_chof;
	}
	public String getEmail_chof() {
		return email_chof;
	}
	public void setEmail_chof(String email_chof) {
		this.email_chof = email_chof;
	}
	public String getN_brevete() {
		return n_brevete;
	}
	public void setN_brevete(String n_brevete) {
		this.n_brevete = n_brevete;
	}
	
	
}
