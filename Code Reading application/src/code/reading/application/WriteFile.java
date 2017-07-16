/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.reading.application;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Sam
 */
public class WriteFile {

    private FileWriter writer;
    public static String path = "";
    public WriteFile(String fileName, String code) {
            writeToFile(fileName, code);
    }

    public void writeToFile(String fileName, String code) {
        File file = new File("src/code/reading/application/" + fileName);
        try {
            file.createNewFile();
            path = file.getAbsolutePath();
            
            writer = new FileWriter(file);
            writer.write(code);
            writer.flush();
            writer.close();
        } catch (Exception e) {

        }
    }
}
