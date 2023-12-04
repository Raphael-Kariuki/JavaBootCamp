package com.m0ckinjay.crud;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("person")
public class MyResource {
    PersonService personService = new PersonService();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    }
    
    @Path("new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPersonEntry(PersonModel person){
        return Response.ok(personService.insertPerson(person)).build();
    }
    
    @Path("all/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() throws SQLException{
        return Response.ok(personService.getallPerson()).build();
    }
    
    @Path("{id}/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons(@PathParam("id") int id) throws SQLException{
        return Response.ok(personService.getPersonById(id)).build();
    }
    
    @Path("{id}/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePersonById(@PathParam("id") int id){
        return Response.ok(personService.deletePersonById(id)).build();
    }
}
