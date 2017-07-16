/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.reading.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Sam
 */
public class ReadFile {

    private FileReader reader;
    private BufferedReader instream;

    public ReadFile() {

    }

    public String readFile(String fileName) {
        String read = "";
        String check = "";
        try {
            reader = new FileReader(fileName);
            instream = new BufferedReader(reader);
            while ( read != null) {
             //   System.out.println(read);
                read = instream.readLine();
                if(read == null) 
                    break;                
                check = check + read + "\n";
            }
            instream.close();

        } catch (Exception e) {
            read = "";
        }
        return check;
    }

    public String readByLine(String fileName) {
        String read;
        try {
            reader = new FileReader(fileName);
            instream = new BufferedReader(reader);
            read = instream.readLine();
            instream.close();
        } catch (Exception e) {
            read = "";

        }
        return read;
    }
}
