/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.infrastructure;

import com.m0ckinjay.domain.Author;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author mo
 */
public class AuthorRepositoryBean implements AuthorRepository {
        private final Map<String, Author> authorsMap = new HashMap<>();
    
    @Override
    public Author saveAuthor(Author author) {
        System.out.println("" + author);
        authorsMap.put(author.getId(), author);
        return author;
                
    }

    @Override
    public List<Author> saveAuthors(List<Author> authors) {
        System.out.println("" + authors);
        authors.forEach(this::saveAuthor);
        return authors;
    }

    @Override
    public Author deleteAuthor(String id) {
        return authorsMap.remove(id);
    }

    @Override
    public List<Author> getAll() {
        return authorsMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Author> getById(String id) {
        return Optional.of(authorsMap.get(id));
        
    }
}
