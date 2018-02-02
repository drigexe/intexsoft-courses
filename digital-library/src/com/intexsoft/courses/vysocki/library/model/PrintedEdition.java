package com.intexsoft.courses.vysocki.library.model;

import java.util.Date;

public abstract class PrintedEdition {
    private String name;
    private String author;
    private String year;
    private String genre;
    private String publisher;
    private String isbn;
    private String editionType;

    /*public PrintedEdition(String name, String author, String year, String genre, String publisher, String isbn) {
        this.setName(name);
        this.setAuthor(author);
        this.setYear(year);
        this.setGenre(genre);
        this.setPublisher(publisher);
        this.setIsbn(isbn);
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditionType() {
        return editionType;
    }

    public void setEditionType(String editionType) {
        this.editionType = editionType;
    }

}
