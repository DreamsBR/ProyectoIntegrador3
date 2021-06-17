package service;

import java.util.List;

import model.empleado;

public interface IEmpleadoService {

empleado registrar(empleado emp) throws Exception;
	
empleado modificar(empleado emp) throws Exception;
	List<empleado> listar() throws Exception;
	empleado buscar(int id_emp) throws Exception;
}
