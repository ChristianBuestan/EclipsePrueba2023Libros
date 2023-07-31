package ups.edu.ec.prueba2023Buestan.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ups.edu.ec.prueba2023Buestan.dao.LibroDao;
import ups.edu.ec.prueba2023Buestan.model.Libro;

@Path("libro")
public class LibroServices {
	@Inject
	LibroDao daoLibro;

	@POST
	@Path("crear")
	@Produces(MediaType.APPLICATION_JSON) //lo mismo que poner app/json
	@Consumes("application/json")
	public String guardarProductoDAO(Libro p) {
		try {
			daoLibro.insert(p);
		} catch (Exception e) {
			return "{\"resultado\": \"ERROR\"}";
			
		}
		return "{\"resultado\": \"OK\"}";
	}
	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> getlistadoProductos(){
		return daoLibro.getList();
	}

}
