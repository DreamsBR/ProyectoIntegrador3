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

import model.vehiculo;
import service.IVehiculoService;
import service.Impl.IVehiculoImpl;

@Path("/vehiculo")
public class VehiculoController {

private IVehiculoService service;
	
    public VehiculoController() 
	{
		this.service=new IVehiculoImpl();
	}
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<vehiculo> listar()
	{
		List<vehiculo> lista= new ArrayList<vehiculo>();
		try {
			lista= service.listar();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@GET
	@Path("/{id_vehiculo}")
	@Produces(MediaType.APPLICATION_JSON)
	public vehiculo buscar(@PathParam("id_vehiculo") int id_vehiculo)
	{
		vehiculo v= new vehiculo();
		try {
			v=service.buscar(id_vehiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public vehiculo registrar(vehiculo vehiculo)
	{
		vehiculo ver= new vehiculo();
		try {
			ver=service.registrar(vehiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ver;
	}

	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public vehiculo modificar(vehiculo vehiculo)
	{
		vehiculo ver= new vehiculo();
		try {
			ver=service.modificar(vehiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ver;
	}
}
