/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.infrastructure.restResources;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author mo
 */
@Stateless
@Path("/authors")
public class AuthorResource {
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getAuthor(){
        return Response.ok("<Author><id>1</id></Author>").build();
    }
}
