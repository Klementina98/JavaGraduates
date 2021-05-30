package com.example.books.RestController;

import com.example.books.Model.Author;
import com.example.books.Service.AuthorService;
import com.example.books.Service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {
    public final AuthorService authorService;
    public final BookService bookService;

    public AuthorRestController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }
    @GetMapping
    public List<Author> listAllAuthors(){
       return this.authorService.listAllAuthors();
    }
}
