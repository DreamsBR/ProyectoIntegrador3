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
@Table(name="tarifario")
public class tarifario {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id_tarifario ;
	@Column
	private String origen ;
	@Column
	private String destino ;
	@Column
	private double monto;
	
	public int getId_tarifario() {
		return id_tarifario;
	}
	public void setId_tarifario(int id_tarifario) {
		this.id_tarifario = id_tarifario;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
}
