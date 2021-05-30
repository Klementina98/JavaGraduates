package com.example.books.Repository;

import com.example.books.Data.DataHolder;
import com.example.books.Model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository  {

    public List<Book> findAll(){
        return  DataHolder.books;
    }
    public Book save(Book book){
        if(book==null){
            return null;
        }
        DataHolder.books.removeIf(r->r.getISBN().equals(book.getISBN()));
        DataHolder.books.add(book);
        return book;

    }
    public Optional<Book> findById(Integer isbn){
        return DataHolder.books.stream().filter(book -> book.getISBN().equals(isbn)).findFirst();
    }
    public void delete(Integer ISBN){
        DataHolder.books.removeIf(b->b.getISBN().equals(ISBN));
    }
}
