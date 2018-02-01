package com.intexsoft.courses.vysocki.library.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    public String getPropertyValue(String propertyName) {
        Properties properties = new Properties();
        InputStream input = null;
        String result = null;

        try {
            input = new FileInputStream(ConstantsUtil.CONFIG_PROPERTIES_FILE_PATH);
            properties.load(input);
            result = properties.getProperty(propertyName);

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

        return result;
    }


}
