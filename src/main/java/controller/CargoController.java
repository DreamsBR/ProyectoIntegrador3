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

import model.cargo;
import service.ICargoService;
import service.Impl.ICargoImpl;


@Path("/cargo")
public class CargoController {

	
private ICargoService service;
	
    public CargoController() 
	{
		this.service=new ICargoImpl();
	}
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<cargo> listar()
	{
		List<cargo> lista= new ArrayList<cargo>();
		try {
			lista= service.listar();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@GET
	@Path("/{id_cargo}")
	@Produces(MediaType.APPLICATION_JSON)
	public cargo buscar(@PathParam("id_cargo") int id_cargo)
	{
		cargo car= new cargo();
		try {
			car=service.buscar(id_cargo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public cargo registrar(cargo cargo)
	{
		cargo car= new cargo();
		try {
			car=service.registrar(cargo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}

	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public cargo modificar(cargo c)
	{
		cargo car= new cargo();
		try {
			car=service.modificar(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}
}
