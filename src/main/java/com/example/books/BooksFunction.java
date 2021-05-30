package com.example.books;

import com.example.books.Data.DataHolder;
import com.example.books.Model.Author;
import com.example.books.Model.Book;
import com.example.books.Model.PrintCopy;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BooksFunction {
    public static HashMap<Author,Integer> hash = new HashMap<>();

    public static DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    public static DateFormat YEAR = new SimpleDateFormat("yyyy");

    //print all books starting with the oldest
    public static void printAllBooks(PrintStream out){
        PrintWriter pw = new PrintWriter(out);
        DataHolder.books.stream().sorted().forEach(pw::println);
        pw.flush();
    }
    //print all books from author whose last name begins with a given letter
    public static void printBooksByAuthors(Character a){
        DataHolder.books.stream().filter(b->b.getAuthor().getFirstCharacterOfAuthorLastName().equals(a))
                .forEach(System.out::println);
    }
    //prints the ids of the authors, whose Printbooks were released in the same decade when the author was born
    public static void printAuthors(){
        List<PrintCopy> printCopies = DataHolder.books.stream().filter(book -> book.getClass().equals(PrintCopy.class)).map(book -> (PrintCopy)book).collect(Collectors.toList());
        printCopies.stream().filter(printCopy -> {
            int offset = Integer.parseInt(printCopy.getAuthor().getYearOfDateOfBirth().substring(0, 3));
            int release = printCopy.getReleaseDate() / 10;
            return release >= offset && release <= offset+1;
        }).map(printCopy -> printCopy.getAuthor().getId()).distinct().forEach(System.out::println);
    }

    //print Authors who have written more than 3 books
    public static void printAuthorsWithMoreThan3Books(){
        DataHolder.books.forEach(book -> {
            hash.putIfAbsent(book.getAuthor(),0);
        });
        DataHolder.books.forEach(book -> {
            if (hash.containsKey(book.getAuthor())) {
                hash.put(book.getAuthor(),hash.get(book.getAuthor())+1);
            }
        });
        hash.entrySet().stream().filter(a->a.getValue() > 3).forEach(System.out::println);
    }
    //it returns the oldest book by release day
    public static Book getOldest(){
        return DataHolder.books.stream().sorted().findFirst().get();
    }
    //it returns the newest book by release day
    public static Book getNewest(){
        return DataHolder.books.stream().sorted(Book.compareByDateOfRelease).findFirst().get();
    }


}
