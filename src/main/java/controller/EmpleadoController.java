package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.empleado;
import service.IEmpleadoService;
import service.Impl.IEmpleadoImpl;

@Path("/empleado")
public class EmpleadoController {

private IEmpleadoService service;
	
    public EmpleadoController() 
	{
		this.service=new IEmpleadoImpl();
	}
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<empleado> listar()
	{
		List<empleado> lista= new ArrayList<empleado>();
		try {
			lista= service.listar();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@GET
	@Path("/{id_emp}")
	@Produces(MediaType.APPLICATION_JSON)
	public empleado buscar(@PathParam("id_emp") int id_emp)
	{
		empleado emp= new empleado();
		try {
			emp=service.buscar(id_emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public empleado registrar(empleado empleado)
	{
		empleado emp= new empleado();
		try {
			emp=service.registrar(empleado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public empleado modificar(empleado empleado)
	{
		empleado emp= new empleado();
		try {
			emp=service.modificar(empleado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
}
