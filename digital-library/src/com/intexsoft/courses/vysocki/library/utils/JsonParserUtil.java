package com.intexsoft.courses.vysocki.library.utils;

import com.intexsoft.courses.vysocki.library.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParserUtil {

    public ArrayList<LibraryDepartment> parseDepartmentsJson(String jsonStr) {
        JSONArray jsonArray = new JSONArray(jsonStr);
        ArrayList<LibraryDepartment> libraryDepartments = new ArrayList<LibraryDepartment>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonobject = jsonArray.getJSONObject(i);
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
        JSONArray jsonArray = new JSONArray(jsonStr);
        ArrayList<PrintedEdition> printedEditions = new ArrayList<PrintedEdition>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
            String author = jsonObject.getString("author");
            String year = jsonObject.getString("year");
            String genre = jsonObject.getString("genre");
            String publisher = jsonObject.getString("publisher");
            String isbn = jsonObject.getString("ISBN");
            String editionType = jsonObject.getString("editionType");
            String equalsBook = "book";
            String equalsJournal = "journal";
            String equalsComics = "comics";
            if (editionType.equals(equalsBook)) {
                Book book = new Book(name, author, year, genre, publisher, isbn, editionType);
                printedEditions.add(book);
            }
            if (editionType.equals(equalsJournal)) {
                String issue = jsonObject.getString("issue");
                Journal journal = new Journal(name, author, year, genre, publisher, isbn, editionType, issue);
                printedEditions.add(journal);
            }
            if (editionType.equals(equalsComics)) {
                String artist = jsonObject.getString("artist");
                Comics comics = new Comics(name, author, year, genre, publisher, isbn, editionType, artist);
                printedEditions.add(comics);
            }
        }
        return printedEditions;
    }

    public String booksToJSON(ArrayList<PrintedEdition> objects) {
        JSONArray jsonArray = new JSONArray(objects);
        return jsonArray.toString();
    }
}
