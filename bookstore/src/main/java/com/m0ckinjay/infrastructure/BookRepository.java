/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m0ckinjay.infrastructure;

import com.m0ckinjay.domain.Book;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mo
 */
public interface BookRepository {
    Book saveBook(final Book book);
    Optional<Book> deleteBok(final String id);
    List<Book> getAll();
    Optional<Book> getByISBN(String isbn);
}
