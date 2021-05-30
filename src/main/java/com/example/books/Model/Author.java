package com.example.books.Model;
import com.example.books.BooksFunction;
import lombok.Data;
import java.util.Date;

@Data
public class Author implements Comparable<Author>{
    private Long id;
    private String name;
    private String lastName;
    private Date yearOfBirth;


    public Author() {}

    public Author(Long id,String name, String lastName, Date yearOfBirth) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }
    public Character getFirstCharacterOfAuthorLastName(){
        return lastName.charAt(0);
    }
    public String getYearOfDateOfBirth(){
        return BooksFunction.YEAR.format(yearOfBirth);
    }

    @Override
    public String toString() {
        return name + ' ' + lastName + ' ' + BooksFunction.df.format(yearOfBirth);
    }

    @Override
    public int compareTo(Author o) {
        return this.id.compareTo(o.id);
    }
}

