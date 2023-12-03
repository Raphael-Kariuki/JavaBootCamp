package com.m0ckinjay.linkedin.learning;

import com.m0ckinjay.linkedin.learning.domain.SalutationRequest;
import com.m0ckinjay.linkedin.learning.domain.SalutationResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("greeting")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @Path("/guest/{guest}/hello")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGreetings(SalutationRequest salutationRequest, @PathParam("guest") String guest){
        SalutationResponse salutationResponse = new SalutationResponse();
        salutationResponse.setSalutation("Hello, " + salutationRequest.getSalutation() +" "+ guest);
        Response responseWrapper = Response.ok(salutationResponse).build();
        return responseWrapper;
    }
    
    @Path("/guest/{guest}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGreetings(@PathParam("guest") String guest){
        String greetings = "Hello " + guest;
        return Response.ok(greetings).build();
    }
}
