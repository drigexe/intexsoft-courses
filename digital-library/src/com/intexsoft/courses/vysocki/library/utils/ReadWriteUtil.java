package com.intexsoft.courses.vysocki.library.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
        } catch (IOException e) {
            System.out.println(e);
        }

        return receivedData;
    }

    public void writeFile(String path, String booksString) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(path));
            writer.write(booksString);

        } catch (IOException e) {

        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
            }
        }

    }

}
