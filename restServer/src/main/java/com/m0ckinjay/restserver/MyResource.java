package com.m0ckinjay.restserver;

import com.m0ckinjay.restserver.db.dbConnection;
import com.m0ckinjay.restserver.db.users;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Map;

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
        Map<String, String> loginUserDetails = dbConnection.checkLogin(userName);
        users systemUser = new users();
        if (loginUserDetails.containsKey("password") && loginUserDetails.containsKey("entryid") && loginUserDetails.containsKey("username")) {
                    systemUser.setPassword(loginUserDetails.get("password"));
                    systemUser.setUsername(loginUserDetails.get("username"));
                    systemUser.setEntryid(Integer.valueOf(loginUserDetails.get("entryid")));
                    

            response = Response.ok(systemUser).build();
        }else{
            response = Response.noContent().build();
        }
        
        return response;
    }
}
