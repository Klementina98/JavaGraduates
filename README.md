# JavaGraduates
Solving tasks

Task no.1

I made one abstract class named "Book" where i store ISBN, title, release day.
I made 2 classes Ebook and PrintCopy which represents the two types of books. These two classes extends from Book.
And made a class Author where i store his name, lastname, date of birth and i add variable id.

Task no.2

In class BooksFunction are implemented all functions that print the required result in the console. In Data package there are class DataHolder where i insert some books and authors and test all these functions.

Task no.3 

I created repositories which on some way represents the access part of the database and I implement some functions that i use in the service layer. In the service layer is the main business logic. Then I made 2 Rest Controllers. One of them (Book restcontroller) meets the requests on path "/api/books" and the other (author) on "api/authors"

I used Postman to test the API requests for save book(EBook or PrintCopy), to edit book (EBook or PrintCopy), to delete book (EBook or PrintCopy), to list all books, and list all authors.

Runtime version: 11.0.7
To start the program just press the debug button.
