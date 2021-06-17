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

import model.chofer;
import service.IChoferService;
import service.Impl.IChoferImpl;

@Path("/chofer")
public class ChoferController {
private IChoferService service;
	
    public ChoferController() 
	{
		this.service=new IChoferImpl();
	}
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<chofer> listar()
	{
		List<chofer> lista= new ArrayList<chofer>();
		try {
			lista= service.listar();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@GET
	@Path("/{id_chofer}")
	@Produces(MediaType.APPLICATION_JSON)
	public chofer buscar(@PathParam("id_chofer") int id_chofer)
	{
		chofer chf= new chofer();
		try {
			chf=service.buscar(id_chofer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chf;
	}
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public chofer registrar(chofer chofer)
	{
		chofer f= new chofer();
		try {
			f=service.registrar(chofer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public chofer modificar(chofer chofer)
	{
		chofer f= new chofer();
		try {
			f=service.modificar(chofer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
