package com.example.books.Data;

import com.example.books.Model.Author;
import com.example.books.Model.Book;

import com.example.books.Model.EBook;
import com.example.books.Model.PrintCopy;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    public static List<Book> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

    @PostConstruct
    public void init() throws ParseException {
        authors.add(new Author(126L,"William","Shakespeare",df.parse("17.12.1564")));
        authors.add(new Author(896L,"Jane","Austen",df.parse("9.2.1817")));
        authors.add(new Author(5693L,"Ernest","Hemingway",df.parse("25.9.1961")));
        authors.add(new Author(125L,"Agatha","Christie",df.parse("17.6.1976")));

        books.add(new EBook(123,"Hamlet",1600, authors.get(0),"epub",23));
        books.add(new EBook(456,"Pride and Prejudice",1813, authors.get(1),"html5",145));
        books.add(new EBook(789,"The Old Man and the Sea",1952, authors.get(2),"epub",11));
        books.add(new EBook(741,"The Mysterious Affair at Styles",1920, authors.get(3),"pdf",365));
        books.add(new PrintCopy(852,"King Lear",2005, authors.get(0),123,2));
        books.add(new PrintCopy(963,"A Farewell to Arms",1929, authors.get(2),1000,2));
        books.add(new PrintCopy(159,"Murder on the Orient Express",1934, authors.get(3),650,1));
        books.add(new PrintCopy(753,"The Tempest",1611, authors.get(0),450,1));
        books.add(new PrintCopy(526,"Twelfth Night",1602,authors.get(0),400,1.3f));

    }


}
