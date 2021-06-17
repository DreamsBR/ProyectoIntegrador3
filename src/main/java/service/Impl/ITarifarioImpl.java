package service.Impl;

import java.util.List;

import dao.ITarifarioDao;
import dao.Impl.TarifarioDaoImpl;
import model.tarifario;
import service.ITarifarioService;

public class ITarifarioImpl implements ITarifarioService{

	private ITarifarioDao dao;
	public ITarifarioImpl()
	{
		dao=new TarifarioDaoImpl();
	}
	@Override
	public tarifario registrar(tarifario t) throws Exception {
		// TODO Auto-generated method stub
		return dao.registrar(t);
	}

	@Override
	public tarifario modificar(tarifario t) throws Exception {
		// TODO Auto-generated method stub
		return dao.modificar(t);
	}

	@Override
	public List<tarifario> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}
	@Override
	public tarifario buscar(int id_tarifario) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscar(id_tarifario);
	}

}
