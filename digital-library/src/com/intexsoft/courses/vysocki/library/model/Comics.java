package com.intexsoft.courses.vysocki.library.model;

public class Comics extends PrintedEdition {
    private String artist;

    public Comics(String name, String author, String year, String genre,
                  String publisher, String isbn, String editionType, String artist) {
        this.setName(name);
        this.setAuthor(author);
        this.setYear(year);
        this.setGenre(genre);
        this.setPublisher(publisher);
        this.setIsbn(isbn);
        this.setEditionType(editionType);
        this.setArtist(artist);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

}
