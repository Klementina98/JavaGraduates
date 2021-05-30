package com.example.books.Model;


public class PrintCopy extends Book {
    private int numOfPages;
    private float weight;

    public PrintCopy(Integer ISBN,String title, int releaseDate, Author author, int numOfPages, float weight) {
        super(ISBN,title, releaseDate, author);
        this.numOfPages = numOfPages;
        this.weight = weight;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return String.format("\"ISBN: %d  Title: %s ReleaseDate: %d Author: %s \nIt's print book \nNumber of pages: %d   Weight: %.2f",
                getISBN(),getTitle(),getReleaseDate(),getAuthor().toString(),numOfPages,weight);
    }
}
