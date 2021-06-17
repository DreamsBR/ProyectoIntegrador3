package service;

import java.util.List;

import model.chofer;


public interface IChoferService {

chofer registrar(chofer f) throws Exception;
	
chofer modificar(chofer f) throws Exception;
	List<chofer> listar() throws Exception;
	chofer buscar(int id_chofer) throws Exception;
}
