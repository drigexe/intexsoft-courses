package com.intexsoft.courses.vysocki.library.model;

public class Journal extends PrintedEdition {
    private String issue;

    public Journal(String name, String author, String year, String genre,
                   String publisher, String isbn, String editionType, String issue) {
        this.setName(name);
        this.setAuthor(author);
        this.setYear(year);
        this.setGenre(genre);
        this.setPublisher(publisher);
        this.setIsbn(isbn);
        this.setEditionType(editionType);
        this.setIssue(issue);
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

}
