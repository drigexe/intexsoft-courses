package com.intexsoft.courses.vysocki.library.model;


public class Book extends PrintedEdition {
    public Book(String name, String author, String year, String genre, String publisher, String isbn, String editionType) {
        this.setName(name);
        this.setAuthor(author);
        this.setYear(year);
        this.setGenre(genre);
        this.setPublisher(publisher);
        this.setIsbn(isbn);
        this.setEditionType(editionType);
    }
}
