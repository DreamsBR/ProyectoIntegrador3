package service.Impl;

import java.util.List;

import dao.IVehiculoDao;
import dao.Impl.VehiculoDaoImpl;
import model.vehiculo;
import service.IVehiculoService;

public class IVehiculoImpl implements IVehiculoService {

	private IVehiculoDao dao;
	public IVehiculoImpl()
	{
		dao=new VehiculoDaoImpl();
	}
	@Override
	public vehiculo registrar(vehiculo v) throws Exception {
		// TODO Auto-generated method stub
		return dao.registrar(v);
	}

	@Override
	public vehiculo modificar(vehiculo v) throws Exception {
		// TODO Auto-generated method stub
		return dao.modificar(v);
	}

	@Override
	public List<vehiculo> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}
	@Override
	public vehiculo buscar(int id_vehiculo) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscar(id_vehiculo);
	}

}
