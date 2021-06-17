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
@Table(name = "cargo")
public class cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cargo;
	@Column
	private String nomb_car; 
	@Column
	private double sueldo_car; 
	@Column
	private String descrip_car;

	public int getId_cargo() {
		return id_cargo;
	}

	public void setId_cargo(int id_cargo) {
		this.id_cargo = id_cargo;
	}

	public String getNomb_car() {
		return nomb_car;
	}

	public void setNomb_car(String nomb_car) {
		this.nomb_car = nomb_car;
	}

	public double getSueldo_car() {
		return sueldo_car;
	}

	public void setSueldo_car(double sueldo_car) {
		this.sueldo_car = sueldo_car;
	}

	public String getDescrip_car() {
		return descrip_car;
	}

	public void setDescrip_car(String descrip_car) {
		this.descrip_car = descrip_car;
	}
	
	
}
