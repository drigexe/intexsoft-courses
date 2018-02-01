package com.intexsoft.courses.vysocki.library.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadWriteUtil {

    public String readFile(String filePath) {
        String receivedData = null;
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filePath));
            Charset encoding = StandardCharsets.UTF_8;
            receivedData = new String(encoded, encoding);
        }
        catch (IOException e) {
            System.out.println(e);
        }

        return receivedData;
    }

}
