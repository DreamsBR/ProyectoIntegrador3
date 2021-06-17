package service;

import java.util.List;

import model.tarifario;

public interface ITarifarioService {

tarifario registrar(tarifario t) throws Exception;
	
tarifario modificar(tarifario t) throws Exception;
	List<tarifario> listar() throws Exception;
	tarifario buscar(int id_tarifario) throws Exception;
}
