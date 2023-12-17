package com.m0ckinjay.restserver;

import com.m0ckinjay.restserver.db.dbConnection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("person")
public class MyResource {
    
    dbConnection dbConnection = new dbConnection();
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
    
    @Path("login/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateLogin(@PathParam("username") String userName){
        Response response = null;
        String password = dbConnection.checkLogin(userName);
        if (password != null && password.length() > 0) {
            response = Response.ok(password).build();
        }else{
            response = Response.noContent().build();
        }
        
        return response;
    }
}
