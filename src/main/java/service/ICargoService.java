package service;

import java.util.List;

import model.cargo;

public interface ICargoService {

	cargo registrar(cargo c) throws Exception;
	cargo modificar(cargo c) throws Exception;
	List<cargo> listar() throws Exception;
	cargo buscar(int id_cargo) throws Exception;
}
