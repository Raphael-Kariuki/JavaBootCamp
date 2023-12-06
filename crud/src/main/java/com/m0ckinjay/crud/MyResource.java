package com.m0ckinjay.crud;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
    
    @Path("{id}/update")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePersonById(@PathParam("id") int id, MultivaluedMap<String, String> formDataMap) throws URISyntaxException{
          /*
        By default a multiValued hashMap values are list objects containing the correspondind form data items/values.
        When fed to a response directly , the json is not nicely formated
        (key, value(key, value)) insted of (key, value) - soln.Iterate and put in hashMap
        */
        //hashMap declaration
        Map<String,String> formParameters = new HashMap<>();

        //iterate the keys
        Iterator<String> it = formDataMap.keySet().iterator();


        while(it.hasNext()){
           String theKey = (String)it.next();
           formParameters.put(theKey,formDataMap.getFirst(theKey));
        }
        PersonModel updatePersonModel = new PersonModel();
        updatePersonModel.setFirstname(formParameters.get("firstName"));
        updatePersonModel.setLastname(formParameters.get("lastName"));
        updatePersonModel.setAge(Integer.parseInt(formParameters.get("age")));
        updatePersonModel.setHeight(Double.parseDouble(formParameters.get("height")));
        int responseInt = personService.specialUpdatePersonById(updatePersonModel, id);
        Response response = null;
        if (responseInt == 1) {
            response = Response.temporaryRedirect(URI.create("/")).build();
        }else{
        response = Response.status(Response.Status.NOT_IMPLEMENTED).location(new URI("/")).build();
        }
        return response;
    }
    @Path("new/register")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerSystemUser(MultivaluedMap<String, String> formDataMap) throws URISyntaxException{
          /*
        By default a multiValued hashMap values are list objects containing the correspondind form data items/values.
        When fed to a response directly , the json is not nicely formated
        (key, value(key, value)) insted of (key, value) - soln.Iterate and put in hashMap
        */
        //hashMap declaration
        Map<String,String> formParameters = new HashMap<>();

        //iterate the keys
        Iterator<String> it = formDataMap.keySet().iterator();


        while(it.hasNext()){
           String theKey = (String)it.next();
           formParameters.put(theKey,formDataMap.getFirst(theKey));
        }
        //initialize user model
        Systemusers registerUser = new Systemusers();
        //get form input
        registerUser.setUsername(formParameters.get("username"));
        registerUser.setFirstname(formParameters.get("firstname"));
        registerUser.setLastname(formParameters.get("lastname"));
        registerUser.setEmailaddress(formParameters.get("emailaddress"));
        registerUser.setPassword(formParameters.get("password"));
        
        String responseInt = personService.registerSystemUser(registerUser);
        Response response = null;
        if (responseInt.equals("1")) {
            response = Response.temporaryRedirect(URI.create("/JSPs/login.jsp")).build();
        }else{
        response = Response.status(Response.Status.NOT_IMPLEMENTED).location(new URI("/")).build();
        }
        return response;
    }
//    @Path("{id}/update")
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updatePersonById(@PathParam("id") int id, PersonModel newPersonModel){
//        return Response.ok(personService.updatePersonById(newPersonModel, id)).build();
//    }
    @Path("{id}/update_")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response specialUpdatePersonById(@PathParam("id") int id, PersonModel newPersonModel){
        return Response.ok(personService.specialUpdatePersonById(newPersonModel, id)).build();
    }
    @Path("{id}/patch")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response patchPersonById(@PathParam("id") int id, PersonModel newPersonModel){
        return Response.ok(personService.patchPersonById(newPersonModel, id)).build();
    }
}
