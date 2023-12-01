/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.rest.server.infrastructure;

import com.m0ckinjay.rest.server.domain.Book;
import jakarta.ejb.EJB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author mo
 */
@EJB
public class BookRepositoryBean implements BookRepository{
    
    @EJB
    private AuthorRepository authorRepository;
    
    private static final String IMAGE_LOCATION = "/image/covers";
    
    private final Map<String, Book> books = new HashMap<>();

    @Override
    public Book saveBook(Book book) {
        System.out.println("book: " + book);
        
        if (book.getImageFileName().length() == 0) {
            book.setImageFileName(IMAGE_LOCATION.concat("no_image.png"));
            
        }
        authorRepository.saveAuthors(book.getAuthors());
        books.put(book.getId(), book);
        
        return book;
    }

    @Override
    public Optional<Book> deleteBok(String id) {
        return Optional.of(books.remove(id));
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Optional<Book> getByISBN(String isbn) {
        return Optional.of(books.get(isbn));
    }
    
}
