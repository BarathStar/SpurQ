package com.spurq.web.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.spurq.web.dao.UserDao;
import com.spurq.web.dao.UserDaoImpl;
import com.spurq.web.domain.User;

import javax.xml.bind.JAXBElement;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Path("/user")
public class UserService {
	@Autowired
	 UserDaoImpl userDao;
 
@GET
 @Path("/{id}")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
 public User getUserById(@PathParam("id") String id) {
 	return userDao.getUser(id);
 }
 
@GET
@Path("/all")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 public List<User> getUserList() {
	  return userDao.getUserList();
	 }

@POST
@Produces(MediaType.TEXT_HTML)
@Consumes(MediaType.APPLICATION_JSON)	
public Response insertData(User user) {
	if( userDao.insertData(user) == true)
  	{
		return Response.status(204).build();
	} else {
		return Response.status(404).entity("User with the id " + user.getUserId() + " is not present in the database").build();
	}
  
}


@PUT 
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.TEXT_HTML})

	 public Response updateData(User user) {
		if( userDao.updateData(user) == true)
	  	{
			return Response.status(204).build();
		} else {
			return Response.status(404).entity("User with the id " + user.getUserId() + " is not present in the database").build();
		}
	  
	 }

	  
	 
	  

@DELETE 
@Path("{id}")
@Produces({MediaType.TEXT_HTML})

	 public Response deleteData(@PathParam("id") String id) {
	 	  
	  if( userDao.deleteData(id) == true)
	  	{
			return Response.status(204).build();
		} else {
			return Response.status(404).entity("User with the id " + id + " is not present in the database").build();
		}
	  
	 }


}
