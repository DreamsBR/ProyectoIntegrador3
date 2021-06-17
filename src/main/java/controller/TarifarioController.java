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

import model.tarifario;
import service.ITarifarioService;
import service.Impl.ITarifarioImpl;

@Path("/tarifario")
public class TarifarioController {


private ITarifarioService service;
	
    public TarifarioController() 
	{
		this.service=new ITarifarioImpl();
	}
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<tarifario> listar()
	{
		List<tarifario> lista= new ArrayList<tarifario>();
		try {
			lista= service.listar();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@GET
	@Path("/{id_tarifario}")
	@Produces(MediaType.APPLICATION_JSON)
	public tarifario buscar(@PathParam("id_tarifario") int id_tarifario)
	{
		tarifario t= new tarifario();
		try {
			t=service.buscar(id_tarifario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public tarifario registrar(tarifario tarifario)
	{
		tarifario ta= new tarifario();
		try {
			ta=service.registrar(tarifario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ta;
	}

	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public tarifario modificar(tarifario tarifario)
	{
		tarifario ta= new tarifario();
		try {
			ta=service.modificar(tarifario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ta;
	}
}
