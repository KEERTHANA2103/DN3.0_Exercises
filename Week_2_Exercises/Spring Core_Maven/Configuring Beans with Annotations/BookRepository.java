package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void findAllBooks() {
        System.out.println("Fetching all books from the repository");
    }
}