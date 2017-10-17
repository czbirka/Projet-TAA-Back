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

import m2.ila.projet.taa.back.dao.UserDAO;
import m2.ila.projet.taa.back.model.User;

@Path("/user")
public class UserResource {

	private UserDAO userDao = new UserDAO();

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll() {
		return userDao.findAll();
	}
	
	@GET
	@Path("name/{nameparam}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findByName(@PathParam("nameparam") String name) {
		return userDao.findByName(name);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findOneById(@PathParam("id") long id) {
		return (Response) userDao.findOneById(id).map(e -> Response.ok().entity(e).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

//	@GET
//	@Path("name/{name}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response findByName(@PathParam("name") String name) {
//		return (Response) userDao.findOneByName(name).map(e -> Response.ok().entity(e).build())
//				.orElse(Response.status(Response.Status.NOT_FOUND).build());
//	}
	
//	@GET
//	@Path("name/{nameparam}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<User> findByName(@PathParam("nameparam") String name) {
//		return userDao.findByName(name);
//	}

	@PUT
	@Path("{name}/{firstname}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void create(@PathParam("name") String name, @PathParam("firstname") String firstname) {
		User u = new User();
		u.setNom(name);
		u.setPrenom(firstname);
		userDao.create(u);
	}

	@POST
	@Path("{id}/{name}/{firstname}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void update(@PathParam("id") long id, @PathParam("name") String name,
			@PathParam("firstname") String firstname) {
		Optional<User> u = userDao.findOneById(id);
		if (u.isPresent()) {
			User uu = u.get();
			uu.setNom(name);
			uu.setPrenom(firstname);
			userDao.update(uu);
		}
	}

	@POST
	@Path("{id}/{name}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateName(@PathParam("id") long id, @PathParam("name") String name)  {
		Optional<User> u = userDao.findOneById(id);
		if (u.isPresent()) {
			User uu = u.get();
			uu.setNom(name);
			userDao.update(uu);
		}
	}
	
	@POST
	@Path("{id}//{firstname}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateFirstname(@PathParam("id") long id, 
			@PathParam("firstname") String firstname) {
		Optional<User> u = userDao.findOneById(id);
		if (u.isPresent()) {
			User uu = u.get();
			uu.setPrenom(firstname);
			userDao.update(uu);
		}
	}
	
	@DELETE
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void delete(@PathParam("id") long id) {
		Optional<User> u = userDao.findOneById(id);
		if (u.isPresent()) {
			User uu = u.get();
			userDao.delete(uu);
		}
	}
	
}
