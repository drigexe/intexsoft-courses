package com.intexsoft.courses.vysocki.library.services;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class LibraryDepartmentService {

    public void makeLibraryDir(){

        //File testLibrary = new File("D:\\Test-library");
        //testLibrary.mkdir();
        //boolean wasSuccessful = testLibrary.mkdir();

        //Path path = Paths.get("D:\\Directory1");
        //Files.createDirectories(path);

        Path path = Paths.get("C:\\Directory2\\Sub2\\Sub-Sub2");
        //if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                //fail to create directory
                e.printStackTrace();
            }
        }

    }
}
