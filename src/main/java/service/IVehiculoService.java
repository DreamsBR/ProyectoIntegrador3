package service;

import java.util.List;

import model.vehiculo;

public interface IVehiculoService {

vehiculo registrar(vehiculo v) throws Exception;
	
vehiculo modificar(vehiculo v) throws Exception;
	List<vehiculo> listar() throws Exception;
	vehiculo buscar(int id_vehiculo) throws Exception;
}
