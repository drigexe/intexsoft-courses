package com.intexsoft.courses.vysocki.library.services;


import com.intexsoft.courses.vysocki.library.utils.PropertiesUtil;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class LibraryDepartmentService {

    public void makeLibraryDir() {
        PropertiesUtil myProp = new PropertiesUtil();
        myProp.getRootLibraryPath();
        Path rootPath = Paths.get(myProp.getRootLibraryPath());
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
