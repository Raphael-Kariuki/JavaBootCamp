/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.webServices;

import com.m0ckinjay.dbConnections.Hmisusers;
import com.m0ckinjay.dbConnections.dbConnection;
import static com.m0ckinjay.dbConnections.dbConnection.getCurrentTimestamp;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mo
 */
//Quext - Watch out
@Path("/register")
public class RegistrationApi {
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUserToDb(MultivaluedMap<String, String> formDataMap){
        
        /*
        By default a multiValued hashMap values are list objects containing the correspondind form data items/values.
        When fed to a response directly , the json is not nicely formated
        (key, value(key, value)) insted of (key, value) - soln.Iterate and put in hashMap
        */
        //hashMap declaration
        Map<String,String> parameters = new HashMap<>();

        //iterate the keys
        Iterator<String> it = formDataMap.keySet().iterator();


        while(it.hasNext()){
           String theKey = (String)it.next();
           parameters.put(theKey,formDataMap.getFirst(theKey));
        }
        /*
                {
  "lName": "rgegeg",
  "emailAddress": "fg@gdf.hg",
  "password": "parameters",
  "fName": "gergerg",
  "userName": "dfwew",
  "confPassword": "parameters"
}
                
                
                */
        Hmisusers hmisusers = new Hmisusers();
        hmisusers.setUsername(parameters.get("userName"));
        hmisusers.setFirstname(parameters.get("fName"));
        hmisusers.setLastname(parameters.get("lName"));
        hmisusers.setEmailaddress(parameters.get("emailAddress"));
        if (parameters.get("password") == null ? parameters.get("confpassword") == null : parameters.get("password").equals(parameters.get("confpassword"))) {
            hmisusers.setPassword(parameters.get("password"));

        }
        //TODO - find a away to get the date the right way, current implementation feels like a back and forth
        SimpleDateFormat formatter5=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
        Date date5 = null;
        try {
            date5 = formatter5.parse(dbConnection.getCurrentTimestamp());
        } catch (ParseException ex) {
            Logger.getLogger(RegistrationApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        hmisusers.setRegistrationdatetime(date5);
        
        //TODO - connectDb() returns null just like in servlet
        String statusReport = dbConnection.dbUserEntry(hmisusers);

        return Response.ok(statusReport).build();
    }
}
