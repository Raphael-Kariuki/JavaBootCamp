/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.webServices;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mo
 */
@Path("/register")
public class RegistrationApi {
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response registerUserToDb(MultivaluedMap<String, String> formDataMap){
       
        List<String> userName = formDataMap.get("userName");
        return Response.ok("<username>"+userName.get(0)+"</username>").build();
    }
}
