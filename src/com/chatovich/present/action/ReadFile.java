package com.chatovich.present.action;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yultos_ on 08.10.2016
 */
public class ReadFile {

    static final Logger LOGGER = LogManager.getLogger(ReadFile.class);

    public static List<String> readFromTXTFile (String fileName) {

        String line;
        List<String> list = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        }catch(FileNotFoundException e){
            LOGGER.fatal("File error", e);
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Problem with reading a file.");
        } finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    LOGGER.log(Level.ERROR, "Problem with reading a file.");
                }
            }
        }
        return list;
    }
}
