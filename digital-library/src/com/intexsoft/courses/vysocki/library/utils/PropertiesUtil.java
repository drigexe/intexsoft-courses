package com.intexsoft.courses.vysocki.library.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    public String getRootLibraryPath() {
        Properties myProp = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(".\\src\\com\\intexsoft\\courses\\vysocki\\library\\config.properties");
            myProp.load(input);
            String unusedString = myProp.getProperty("ROOT_LIBRARY_PATH");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return myProp.getProperty("ROOT_LIBRARY_PATH");
    }

    public String getLibraryDepartmentsPath() {
        Properties myProp = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(".\\src\\com\\intexsoft\\courses\\vysocki\\library\\config.properties");
            myProp.load(input);
            String unusedString = myProp.getProperty("LIBRARY_DEPARTMENTS_PATH");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return myProp.getProperty("LIBRARY_DEPARTMENTS_PATH");
    }

}
