package com.example.books.Model;

public class EBook extends Book {
    private String format;
    private float size;

    public EBook(Integer ISBN,String title, int releaseDate, Author author, String format, float size) {
        super(ISBN,title, releaseDate,author);
        this.format = format;
        this.size = size;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return String.format("ISBN: %d  Title: %s ReleaseDate: %d Author: %s \nIt's Digital book \nFormat: %s   Size: %.2f",
                getISBN(),getTitle(), getReleaseDate(), getAuthor().toString(), format,size);
    }
}