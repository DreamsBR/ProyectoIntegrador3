package dao;

import java.util.List;

import model.vehiculo;

public interface IVehiculoDao {

	vehiculo registrar(vehiculo v);
	
	vehiculo modificar(vehiculo v);
	
	List<vehiculo> listar();
	
	vehiculo buscar(int id_vehiculo);
}
