package com.intexsoft.courses.vysocki.library.services;

import com.intexsoft.courses.vysocki.library.model.*;
import com.intexsoft.courses.vysocki.library.utils.JsonParserUtil;
import com.intexsoft.courses.vysocki.library.utils.ReadWriteUtil;

import java.util.ArrayList;

public class BookService {
    private ArrayList<PrintedEdition> printedEditions = new ArrayList<PrintedEdition>();

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
}
