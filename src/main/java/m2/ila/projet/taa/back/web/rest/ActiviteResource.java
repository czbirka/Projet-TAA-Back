package m2.ila.projet.taa.back.web.rest;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import m2.ila.projet.taa.back.dao.ActiviteDAO;
import m2.ila.projet.taa.back.model.Activite;

@Path("/activite")
public class ActiviteResource {

	private ActiviteDAO activiteDAO = new ActiviteDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activite> getAll() {
		return activiteDAO.findAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") long id) {
		return (Response) activiteDAO.findOneById(id).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

	@GET
	@Path("nom/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByName(@PathParam("nom") String nom) {
		return (Response) activiteDAO.findOneByName(nom).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

	@PUT
	@Path("{nom}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(@PathParam("nom") String nom) {
		Activite a = new Activite();
		a.setNom(nom);
		activiteDAO.create(a);
	}

	@POST
	@Path("{id}/{nom}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void update(@PathParam("id") long id, @PathParam("nom") String nom) {
		Optional<Activite> a = activiteDAO.findOneById(id);
		if (a.isPresent()) {
			Activite aa = a.get();
			aa.setNom(nom);
			activiteDAO.update(aa);
		}
	}

	@DELETE
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void delete(@PathParam("id") long id) {
		Optional<Activite> a = activiteDAO.findOneById(id);
		if (a.isPresent()) {
			Activite aa = a.get();
			activiteDAO.delete(aa);
		}
	}
	
}
