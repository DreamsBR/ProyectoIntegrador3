package dao;

import java.util.List;

import model.chofer;

public interface IChoferDao {

	 chofer registrar(chofer f);
		
	 chofer modificar(chofer f);
		
		List<chofer> listar();
		chofer buscar(int id_chofer);
}
