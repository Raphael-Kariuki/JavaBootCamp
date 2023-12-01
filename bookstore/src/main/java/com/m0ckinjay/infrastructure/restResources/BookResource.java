/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.infrastructure.restResources;

import com.m0ckinjay.domain.Book;
import com.m0ckinjay.infrastructure.BookRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mo
 */
@Stateless
@Path("/books")
public class BookResource {
    
    @EJB 
    private BookRepository bookRepository;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks(){
        List<Book> books = bookRepository.getAll();
        GenericEntity<List<Book>> bookWrapper = new GenericEntity<List<Book>>(books){};
        return Response.ok(bookWrapper).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveBook(Book book){
        Book persistedBook = bookRepository.saveBook(book);
        return Response.ok(persistedBook).build();
               
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{isbn: \\d{9}[\\d|X]$}")
    public Response getByISBN(final @PathParam("isbn") String isbn){
        Optional<Book> book = bookRepository.getByISBN(isbn);
        
        if (book.isPresent()) {
            return Response.ok(book).build();
        }
        return Response.noContent().build();
    }
    
    
    
}
