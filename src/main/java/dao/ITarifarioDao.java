package dao;

import java.util.List;

import model.tarifario;

public interface ITarifarioDao {

	tarifario registrar(tarifario t);
	
	tarifario modificar(tarifario t);
	
	List<tarifario> listar();
	
	tarifario buscar(int id_tarifario);
}
