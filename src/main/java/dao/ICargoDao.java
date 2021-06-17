package dao;

import java.util.List;

import javax.ejb.Local;

import model.cargo;

@Local
public interface ICargoDao {

	    cargo registrar(cargo c);
		
		cargo modificar(cargo c);
		
		List<cargo> listar();

		cargo buscar(int id_cargo);
}
