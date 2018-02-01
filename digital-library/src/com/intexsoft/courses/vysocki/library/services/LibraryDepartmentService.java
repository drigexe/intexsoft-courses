package com.intexsoft.courses.vysocki.library.services;


import com.intexsoft.courses.vysocki.library.model.LibraryDepartment;
import com.intexsoft.courses.vysocki.library.utils.ConstantsUtil;
import com.intexsoft.courses.vysocki.library.utils.JsonParserUtil;
import com.intexsoft.courses.vysocki.library.utils.PropertiesUtil;
import com.intexsoft.courses.vysocki.library.utils.ReadWriteUtil;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.ArrayList;

public class LibraryDepartmentService {
    private ArrayList<LibraryDepartment> libraryDepartments = new ArrayList<LibraryDepartment>();

    public void loadDepartments() {
        ReadWriteUtil readWriteUtil = new ReadWriteUtil();
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        String libraryDepartmentsPath = propertiesUtil.getPropertyValue(ConstantsUtil.LIBRARY_DEPARTMENTS_PATH);
        String receivedData = readWriteUtil.readFile(libraryDepartmentsPath);
        JsonParserUtil jsonParserUtil = new JsonParserUtil();
        this.libraryDepartments = jsonParserUtil.parseDepartmentsJson(receivedData);
    }

    public ArrayList<LibraryDepartment> getLibraryDepartments() {
        this.loadDepartments();
        return libraryDepartments;
    }

}




