package com.example.books.Model;

import java.util.Comparator;

public abstract class Book implements Comparable<Book> {
    private Integer ISBN;
    private String title;
    private Integer releaseDate;
    private Author author;

    public static Comparator<Book> compareByDateOfRelease = Comparator.comparing(Book::getReleaseDate).reversed();


    public Book(Integer ISBN, String title,Integer releaseDate, Author author) {
        this.ISBN = ISBN;
        this.title = title;
        this.releaseDate = releaseDate;
        this.author = author;
    }
    public int compareTo(Book b) {
        return this.releaseDate.compareTo(b.releaseDate);
    }

    @Override
    public abstract String toString();

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

