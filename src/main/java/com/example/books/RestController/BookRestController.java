package com.example.books.RestController;

import com.example.books.Model.Book;
import com.example.books.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
    public final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> listAllBooks(){ //work
        return this.bookService.listAllBooks();
    }
    @PostMapping("/saveEBook")
    public Book saveNewEBook(Integer ISBN,String title, Integer releaseDate, Long AuthorId, String format, float size){
        return this.bookService.saveEBook(ISBN,title,releaseDate,AuthorId,format,size); //work
    }
    @PostMapping("/savePrintBook")
    public Book savePrintBook(Integer ISBN,String title, Integer releaseDate, Long AuthorId, int numOfPages, float weight){
        return this.bookService.savePrintCopy(ISBN,title,releaseDate,AuthorId,numOfPages,weight); //work
    }
    @PutMapping("/editEBook/{isbn}")
    public Book editEBook(@PathVariable Integer isbn,String title, Integer releaseDate, Long AuthorId, String format, Float size){
        return this.bookService.editEBook(isbn,title,releaseDate,AuthorId,format,size); //work
    }
    @PutMapping("/editPrintBook/{isbn}")
    public Book editPrintBook(@PathVariable Integer isbn, String title, Integer releaseDate, Long AuthorId, int numOfPages, float weight){
        return this.bookService.editPrintCopy(isbn,title,releaseDate,AuthorId,numOfPages,weight); //work
    }
    @DeleteMapping("/deleteBook/{isbn}")
    public void deleteBook(@PathVariable Integer isbn){
        this.bookService.deleteBook(isbn); //work
    }
}
