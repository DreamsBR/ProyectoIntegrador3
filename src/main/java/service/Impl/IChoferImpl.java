package service.Impl;

import java.util.List;

import dao.IChoferDao;
import dao.Impl.ChoferDaoImpl;
import model.chofer;
import service.IChoferService;

public class IChoferImpl implements IChoferService{

	private IChoferDao dao;
	public IChoferImpl()
	{
		dao=new ChoferDaoImpl();
	}
	@Override
	public chofer registrar(chofer f) throws Exception {
		// TODO Auto-generated method stub
		return dao.registrar(f);
	}

	@Override
	public chofer modificar(chofer f) throws Exception {
		// TODO Auto-generated method stub
		return dao.modificar(f);
	}

	@Override
	public List<chofer> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}
	@Override
	public chofer buscar(int id_chofer) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscar(id_chofer);
	}

}
