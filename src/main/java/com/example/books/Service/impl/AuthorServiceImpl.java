package com.example.books.Service.impl;

import com.example.books.Model.Author;
import com.example.books.Repository.AuthorRepository;
import com.example.books.Repository.BookRepository;
import com.example.books.Service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    public final BookRepository bookRepository;
    public final AuthorRepository authorRepository;

    public AuthorServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    @Override
    public List<Author> listAllAuthors() {
        return this.authorRepository.findAll();
    }
}
