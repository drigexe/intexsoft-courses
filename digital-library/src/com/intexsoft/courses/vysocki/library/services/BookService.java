package com.intexsoft.courses.vysocki.library.services;

import com.intexsoft.courses.vysocki.library.model.*;
import com.intexsoft.courses.vysocki.library.utils.JsonParserUtil;
import com.intexsoft.courses.vysocki.library.utils.ReadWriteUtil;

import java.util.ArrayList;

public class BookService {
    private ArrayList<PrintedEdition> printedEditions = new ArrayList<PrintedEdition>();
    private ArrayList<PrintedEdition> filteredEditions = new ArrayList<PrintedEdition>();
    private ReadWriteUtil readWriteUtil = new ReadWriteUtil();
    private JsonParserUtil jsonParserUtil = new JsonParserUtil();


    public void loadBooks(String chosenFinalDepartmentPath) {
        ReadWriteUtil readWriteUtil = new ReadWriteUtil();
        String receivedData = readWriteUtil.readFile(chosenFinalDepartmentPath);
        JsonParserUtil jsonParserUtil = new JsonParserUtil();
        this.printedEditions = jsonParserUtil.parseBooksJson(receivedData);
    }

    public ArrayList<PrintedEdition> getPrintedEditions(String chosenFinalDepartmentPath) {
        this.loadBooks(chosenFinalDepartmentPath);
        return printedEditions;
    }

    public void filterByAuthor(String booksPath, String booksByAuthorPath, String enteredAuthor) {
        this.loadBooks(booksPath);
        for (int i = 0; i < this.printedEditions.size(); i++) {
            if (this.printedEditions.get(i).getAuthor().equals(enteredAuthor)) {
                this.filteredEditions.add(this.printedEditions.get(i));
            }
        }
        String booksString = jsonParserUtil.booksToJSON(this.filteredEditions);
        readWriteUtil.writeFile(booksByAuthorPath, booksString);
    }

    public void filterByGenre(String booksPath, String booksByGenrePath, String enteredGenre) {
        this.loadBooks(booksPath);
        for (int i = 0; i < this.printedEditions.size(); i++) {
            if (this.printedEditions.get(i).getGenre().equals(enteredGenre)) {
                this.filteredEditions.add(this.printedEditions.get(i));
            }
        }
        String booksString = jsonParserUtil.booksToJSON(this.filteredEditions);
        readWriteUtil.writeFile(booksByGenrePath, booksString);
    }

    public void filterByType(String booksPath, String booksByTypePath, String enteredType) {
        this.loadBooks(booksPath);
        for (int i = 0; i < this.printedEditions.size(); i++) {
            if (this.printedEditions.get(i).getEditionType().equals(enteredType)) {
                this.filteredEditions.add(this.printedEditions.get(i));
            }
        }
        String booksString = jsonParserUtil.booksToJSON(this.filteredEditions);
        readWriteUtil.writeFile(booksByTypePath, booksString);
    }
}
