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

    public void makeRootLibraryDir() {
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        Path rootPath = Paths.get(propertiesUtil.getPropertyValue(ConstantsUtil.ROOT_LIBRARY_PATH));
        //if directory exists?
        if (!Files.exists(rootPath)) {
            try {
                Files.createDirectories(rootPath);
            } catch (IOException e) {
                //fail to create directory
                e.printStackTrace();
            }
        }
    }
}




