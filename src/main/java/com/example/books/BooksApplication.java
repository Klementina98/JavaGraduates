package com.example.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class, args);
        BooksFunction.printAllBooks(System.out); //done
        BooksFunction.printBooksByAuthors('A'); //done
        BooksFunction.printAuthorsWithMoreThan3Books(); //done
        System.out.println("The oldest book is:\n" +BooksFunction.getOldest()); //done
        System.out.println("The newest book is: \n" +BooksFunction.getNewest()); //done
        BooksFunction.printAuthors(); //done
    }

}
