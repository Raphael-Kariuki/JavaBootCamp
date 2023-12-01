/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m0ckinjay.infrastructure;

import com.m0ckinjay.domain.Author;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mo
 */
public interface AuthorRepository {
        
    Author saveAuthor(final Author author);
    List<Author> saveAuthors(List <Author> authors);
    Author deleteAuthor(final String id);
    List<Author> getAll();
    Optional<Author> getById(String id);
}
