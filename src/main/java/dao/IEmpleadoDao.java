package dao;

import java.util.List;

import model.empleado;

public interface IEmpleadoDao {

	empleado registrar(empleado emp);
		
	empleado modificar(empleado emp);
		
		List<empleado> listar();
		
		empleado buscar(int id_emp);
}
