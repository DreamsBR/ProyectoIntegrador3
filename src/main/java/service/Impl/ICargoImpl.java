package service.Impl;

import java.util.List;

import dao.ICargoDao;
import dao.Impl.CargoDaoImpl;
import model.cargo;
import service.ICargoService;

public class ICargoImpl implements ICargoService{

	private ICargoDao dao;
	public ICargoImpl()
	{
		dao=new CargoDaoImpl();
	}
	@Override
	public cargo registrar(cargo c) throws Exception {
		// TODO Auto-generated method stub
		return dao.registrar(c);
	}
	@Override
	public cargo modificar(cargo c) throws Exception {
		// TODO Auto-generated method stub
		return dao.modificar(c);
	}
	@Override
	public List<cargo> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}
	@Override
	public cargo buscar(int id_cargo) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscar(id_cargo);
	}

}
