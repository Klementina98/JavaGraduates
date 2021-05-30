package com.example.books.Service.impl;

import com.example.books.Model.Author;
import com.example.books.Model.Book;
import com.example.books.Model.EBook;
import com.example.books.Model.PrintCopy;
import com.example.books.Repository.AuthorRepository;
import com.example.books.Repository.BookRepository;
import com.example.books.Service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    public final BookRepository bookRepository;
    public final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAllBooks() {

        return this.bookRepository.findAll();
    }

    @Override
    public Book saveEBook(Integer ISBN,String title, Integer releaseDate, Long AuthorId, String format, float size) {
        Author auhor = this.authorRepository.findById(AuthorId).get();
        Book ebook = new EBook(ISBN,title,releaseDate,auhor,format,size);
        return this.bookRepository.save(ebook);
    }

    @Override
    public Book savePrintCopy(Integer ISBN,String title, Integer releaseDate, Long AuthorId, int numOfPages, float weight) {
        Author auhor = this.authorRepository.findById(AuthorId).get();
        return this.bookRepository.save(new PrintCopy(ISBN,title,releaseDate,auhor,numOfPages,weight));
    }

    @Override
    public Book editEBook(Integer isbn, String title, Integer releaseDate, Long AuthorId, String format, float size) {
        Author auhor = this.authorRepository.findById(AuthorId).get();
        EBook bookToEdit = (EBook) this.bookRepository.findById(isbn).get();
        bookToEdit.setTitle(title);
        bookToEdit.setAuthor(auhor);
        bookToEdit.setReleaseDate(releaseDate);
        bookToEdit.setFormat(format);
        bookToEdit.setSize(size);
        return bookRepository.save(bookToEdit);
    }

    @Override
    public Book editPrintCopy(Integer isbn, String title, Integer releaseDate, Long AuthorId, int numOfPages, float weight) {
        Author auhor = this.authorRepository.findById(AuthorId).get();
        PrintCopy bookToEdit = (PrintCopy) this.bookRepository.findById(isbn).get();
        bookToEdit.setTitle(title);
        bookToEdit.setAuthor(auhor);
        bookToEdit.setReleaseDate(releaseDate);
        bookToEdit.setNumOfPages(numOfPages);
        bookToEdit.setWeight(weight);
        return bookRepository.save(bookToEdit);

    }

    @Override
    public void deleteBook(Integer isbn) {
        this.bookRepository.delete(isbn);
    }
}
