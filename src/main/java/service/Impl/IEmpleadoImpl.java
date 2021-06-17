package service.Impl;

import java.util.List;

import dao.IEmpleadoDao;
import dao.Impl.EmpleadoDaoImpl;
import model.empleado;
import service.IEmpleadoService;

public class IEmpleadoImpl implements IEmpleadoService {

	private IEmpleadoDao dao;
	public IEmpleadoImpl()
	{
		dao=new EmpleadoDaoImpl();
	}
	@Override
	public empleado registrar(empleado emp) throws Exception {
		// TODO Auto-generated method stub
		return dao.registrar(emp);
	}

	@Override
	public empleado modificar(empleado emp) throws Exception {
		// TODO Auto-generated method stub
		return dao.modificar(emp);
	}

	@Override
	public List<empleado> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}
	@Override
	public empleado buscar(int id_emp) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscar(id_emp);
	}

}
