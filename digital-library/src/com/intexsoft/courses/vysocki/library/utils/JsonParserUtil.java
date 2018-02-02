package com.intexsoft.courses.vysocki.library.utils;

import com.intexsoft.courses.vysocki.library.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParserUtil {

    public ArrayList<LibraryDepartment> parseDepartmentsJson(String jsonStr) {
        JSONArray jsonarray = new JSONArray(jsonStr);
        ArrayList<LibraryDepartment> libraryDepartments = new ArrayList<LibraryDepartment>();
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            String id = jsonobject.getString("id");
            String name = jsonobject.getString("name");
            String website = jsonobject.getString("website");
            String path = jsonobject.getString("path");
            LibraryDepartment libraryDepartment = new LibraryDepartment(name, website, path, id);
            libraryDepartments.add(libraryDepartment);
        }
        return libraryDepartments;
    }

    public ArrayList<PrintedEdition> parseBooksJson(String jsonStr) {
        JSONArray jsonarray = new JSONArray(jsonStr);
        ArrayList<PrintedEdition> printedEditions = new ArrayList<PrintedEdition>();
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            String name = jsonobject.getString("name");
            String author = jsonobject.getString("author");
            String year = jsonobject.getString("year");
            String genre = jsonobject.getString("genre");
            String publisher = jsonobject.getString("publisher");
            String isbn = jsonobject.getString("ISBN");
            String editionType = jsonobject.getString("editionType");
            String equalsBook = "book";
            String equalsJournal = "journal";
            String equalsComics = "comics";
            if (editionType.equals(equalsBook)) {
                Book book = new Book(name, author, year, genre, publisher, isbn, editionType);
                printedEditions.add(book);
            }
            if (editionType.equals(equalsJournal)) {
                Journal journal = new Journal(name, author, year, genre, publisher, isbn, editionType);
                printedEditions.add(journal);
            }
            if (editionType.equals(equalsComics)) {
                Comics comics = new Comics(name, author, year, genre, publisher, isbn, editionType);
                printedEditions.add(comics);
            }
        }
        return printedEditions;
    }

}
