package com.example.books.Service;

import com.example.books.Model.Book;
import java.util.List;

public interface BookService {
    List<Book> listAllBooks();
    Book saveEBook(Integer isbn,String title,Integer releaseDate, Long AuthorId, String format, float size);
    Book savePrintCopy(Integer isbn,String title,Integer releaseDate, Long AuthorId, int numOfPages, float weight);
    Book editEBook(Integer isbn, String title, Integer releaseDate, Long AuthorId, String format, float size);
    Book editPrintCopy(Integer isbn, String title, Integer releaseDate, Long AuthorId, int numOfPages, float weight);
    void deleteBook(Integer isbn);
}
